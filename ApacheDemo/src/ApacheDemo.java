
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * A dirty simple program that reads an Excel file.
 * 
 * @author www.codejava.net
 *
 */
public class ApacheDemo {

	public static void main(String[] args) throws IOException {
		String excelFilePath = "results-from-proctored-and-practice-exams-20160214.xls";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		Sheet sheet;

		sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
	    while (rowIterator.hasNext()) {
	      Row row = rowIterator.next();
	      Cell cell = row.getCell(0);
	      
	    }
		for (int i = 0; i < 500; i++) {
			Row row = sheet.getRow(i);
			if (row == null) {
				// do something with an empty row
				continue;
			}
			for (int j = 0; j < 10; j++) {
				Cell cell = row.getCell(j);
				if (cell == null) {
					// do something with an empty cell
					continue;
				}
				cell.setCellType(Cell.CELL_TYPE_STRING);
				String c = cell.getStringCellValue();

				System.out.print(c + "\t\t");
			}
			System.out.println("");
		}

		workbook.close();
		inputStream.close();
		// for (int i = 0; i < list.size(); i++){
		// System.out.println(list.get(i));
		// }
		System.out.println("Done");
	}

}