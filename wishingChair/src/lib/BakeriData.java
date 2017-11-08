package lib;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class BakeriData extends CommonExcel {
	public int iTestCaseID;
	public String sNo;
	public String sDD;
//	public static int startline = 1;
	
	public static Object[][] getData(Sheet sheet, int iCount) throws Exception
	{
		Object [][] swData = new Object[iCount][2];
		BakeriData plan = null;

		for(int i = 0; i < iCount; i++)
		{
			plan = new BakeriData();

			Row iRow= sheet.getRow(i + 1);
			plan.iTestCaseID=i+1;

			plan.sNo	= CommonExcel.getExcelCellValue(iRow,1);
			plan.sDD	= CommonExcel.getExcelCellValue(iRow,2);
			
			swData[i][0] = plan.iTestCaseID;
			swData[i][1] = plan;
			
			for (int l=0;i<iCount;i++){
				for (int j=0;j<2;j++){
					System.out.println("swData["+l+"]["+j+"]"+swData[l][j]);
				}
			}
		}
		return swData;
	}

	@Override
	public String toString() {
		return "BakeriData [iTestCaseID=" + iTestCaseID + ", sNo=" + sNo + "]";
	}
}
