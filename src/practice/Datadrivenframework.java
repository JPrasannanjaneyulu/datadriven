package practice;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Datadrivenframework 
{
	public static void main(String[] args) throws BiffException, IOException, RowsExceededException, WriteException 
	{
		//Open excel file for read
		File f=new File("testdata.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);// 0 means sheet1
		int nor=rsh.getRows();// used rows count
		//Open excel file for write
		WritableWorkbook wwb=Workbook.createWorkbook(f, rwb);
		WritableSheet wsh=wwb.getSheet(0);// 0 means sheet1
		//Data driven from 1st (2nd) row to last row
		//0th (1st) row have names of columns
		for(int i=1; i<nor; i++)
		{
			String x=rsh.getCell(0, i).getContents();
			String y=rsh.getCell(1, i).getContents();
			int a=Integer.parseInt(x);
			int b=Integer.parseInt(y);
			int z=a+b;
			Number n=new Number(2, i, z);
			wsh.addCell(n);
		}
		wwb.write();//save changes in excel file
		wwb.close();
		rwb.close();
	}
}
