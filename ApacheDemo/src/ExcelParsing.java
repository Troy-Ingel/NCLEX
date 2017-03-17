

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * A dirty simple program that reads an Excel file.
 * 
 * @author www.codejava.net
 *
 */
public class ExcelParsing {

	public static void main(String[] args) throws IOException {
		String excelFilePath = "results-from-proctored-and-practice-exams-20160214.xls";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		DataFormatter formatter = new DataFormatter();
		Sheet sheet;

		sheet = workbook.getSheetAt(0);
		int numRows = 0;
		int numCols = 0;
		for(;;){
			String text = formatter.formatCellValue(sheet.getRow(numRows+1).getCell(0));
			if (text.length() > 0){
				numRows++;
			}else break;
		}
		for(;;){
			String text = formatter.formatCellValue(sheet.getRow(0).getCell(numCols));
			if (text.length() > 0){
				numCols++;
			}else break;
		}
		System.out.println("Rows: " + numRows + " Colums: " + numCols);
		System.out.println(" ");
		for(int r = 0; r <= numRows; r++){
			for(int c = 0; c < 10; c++){
				String text = formatter.formatCellValue(sheet.getRow(r).getCell(c));
				System.out.print(text);
				System.out.print("\t\t");
				
			
			}
			System.out.println("");
		}
	    

		workbook.close();
		inputStream.close();
		
		System.out.println("Done");
	}

}