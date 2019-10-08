import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDataConfig {
	HSSFWorkbook wb;
	HSSFSheet sheet;
	
	public ExcelDataConfig(String excelDataPath){
		try {
			File src=new File(excelDataPath);
			FileInputStream fis=new FileInputStream(src);
			 wb=new HSSFWorkbook(fis);//HSSFWorkbook for xls  // XSSFWorkbook for xlxs
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	public String getData(int sheetNum, int row, int col) {
		
		sheet=wb.getSheetAt(sheetNum);
		String data=sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
		
		}
	public int getRowCount(int sheetIndex) {
		int row= wb.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		return row;
	}
public int getColCount(int sheetIndex) {
	int col=wb.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
    return col;
}