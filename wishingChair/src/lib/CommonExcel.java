package lib;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CommonExcel {
//	public static XSSFSheet sheet;
	public static int iCount;
//	public static XSSFWorkbook wb;

	@DataProvider
	private static Object[][] getData() throws Exception
	{
		Object[][] bakeriData = null;
		FileInputStream fis =null;
		try
		{
			fis = new FileInputStream(CommonClass.DATA_PATH);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(CommonClass.SHEET);
			
			iCount = CommonClass.TESTCASES;
			bakeriData = new Object [iCount][2];
			
			bakeriData = BakeriData.getData(sheet, iCount);
			wb.close();
		}
		catch (Exception ex){System.out.println(ex);}
		finally 
		{
			if(fis!=null)
			{
				try{fis.close();}
				catch (Exception e){}
			}
		}
		for (int i=0;i<iCount;i++){
			for (int j=0;j<2;j++){
				System.out.println("bakeriData["+i+"]["+j+"]"+bakeriData[i][j]);
			}
		}
		
		return bakeriData ;
	}
	
	public static String getExcelCellValue(Row row, int iCell)
	{
		String sRetValue = "";
		try 
		{
			System.out.println("getCellvalue");
			if(row.getCell(iCell).getCellTypeEnum()==CellType.STRING)
				sRetValue = row.getCell(iCell).getStringCellValue().trim();
			else
				sRetValue = String.valueOf((long)row.getCell(iCell).getNumericCellValue()).trim();
		} 
		catch (NullPointerException ex) {}
		return sRetValue;
	}
	
	
	public void setExcelCellValue(int iRow, int iCell, String sdata) throws Exception {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		XSSFSheet sheet;
		XSSFWorkbook wb;
		fis = new FileInputStream(CommonClass.DATA_PATH);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(CommonClass.SHEET); 
		try {
			sheet.getRow((iRow)).createCell(iCell).setCellValue(sdata);
			fos = new FileOutputStream(CommonClass.DATA_PATH);
			wb.write(fos);

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if(fos != null)
			{
				try {
					fos.flush(); 
					fos.close(); 
					wb.close();}
				catch(Exception ex){}
			}
		}
	}

}
