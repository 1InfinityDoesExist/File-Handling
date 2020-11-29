package in.csv.csvManipulate.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ProcessCSVFile {

	public static void writeIntoCSVFile() {
		@SuppressWarnings("resource")
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet("Shinchan Details");
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "ID", "NAME", "LASTNAME" });
		data.put("2", new Object[] { 1, "Amit", "Shukla" });
		data.put("3", new Object[] { 2, "Lokesh", "Gupta" });
		data.put("4", new Object[] { 3, "John", "Adwards" });
		data.put("5", new Object[] { 4, "Brian", "Schultz" });

		Set<String> keySet = data.keySet();
		int rowNumber = 0;
		for (String key : keySet) {
			Row row = sheet.createRow(rowNumber++);
			int cellNumber = 0;
			Object[] objArr = data.get(key);
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellNumber++);
				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				}
				if (obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}
			}
		}
		File file = new File("Sinchan.xlsx");
		try {
			FileOutputStream outputStream = new FileOutputStream(file);
			workBook.write(outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFromCSVFile() {
		try {
			FileInputStream fis = new FileInputStream(
					new File("/home/gaian/Videos/fbAccessTokenVeification/csvManipulate/Sinchan.xlsx"));
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.iterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getCellType() == CellType.STRING) {
						System.out.print("::::::" + cell.getStringCellValue());
					}
					if (cell.getCellType() == CellType.NUMERIC) {
						System.out.print("::::::" + cell.getNumericCellValue());
					}
				}
				System.out.println("");
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
