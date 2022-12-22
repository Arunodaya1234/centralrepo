package excellUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utility.Constants;

public class ReadExcelSheet 
{
	public ArrayList readExcellData(int colNo) throws IOException
	{
		String filePath=Constants.filePath;
		File file=new File(filePath);
		System.out.println(filePath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		Iterator<Row> row=sheet.rowIterator();
		ArrayList<String> ar=new ArrayList<String>();
		while(row.hasNext())
		{
			Row r=row.next();
			Cell c=r.getCell(colNo);
			String data=c.getStringCellValue();
			ar.add(data);
		}
		System.out.println("List:"+ar);
		return ar;	
	}
	
//	public static void main(String arr[]) throws IOException
//	{
//		readExcellData(0);
//	}
}
