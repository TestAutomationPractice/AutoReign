/**
 * 
 */
package com.crm.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

/**
 * @author U735770
 *
 */
public class ExcelProcessor {

	public static String origin = null;
	public static String destination = null;
	public static String deliveryDate = null;
	public static String pickupDate = null;
	public static String commodity = null;
	public static String product = null;
	public static String speed = null;
	public static String shipName = null;
	public static String shipStreet = null;
	public static String shipCity = null;
	public static String shipState = null;
	public static String shipPostalCode = null;
	public static String shipCountry = null;
	public static String consName = null;
	public static String consStreet = null;
	public static String consCity = null;
	public static String consState = null;
	public static String consPostalCode = null;
	public static String consCountry = null;
	public static String noOfPieces = null;
	public static String grossWeight = null;
	public static String totalVolume = null;
	public static String densityFactor = null;
	public static String awbNumber = null;
	public static String eFright = null;
	public static String phoneTwentyFour = null;
	public static String EmailAddressTwentyFour = null;
	
	static String filePath = "D:\\luftans.cargo.befe_workspace\\cargo.befe_workspace\\neueBEMaven\\test-input\\TestData.xlsx";

	public static Map<String, String> Data = new HashedMap<String, String>();
	private int rows;

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public static String readData(int rowNum, int cellNum) throws InvalidFormatException {
		String data = "";
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(filePath)));
			data = wb.getSheet("ShipmentData").getRow(rowNum).getCell(cellNum).getStringCellValue();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static int getRowCount() {
		int number = 0;
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(filePath)));
			number = wb.getSheet("ShipmentData").getLastRowNum();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return number;
	}

	public static int getColumnCount() {
		int number = 0;
		try {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(filePath)));
			number = wb.getSheet("ShipmentData").getRow(0).getLastCellNum();
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return number;
	}

	public Map<String, String> getTestData(String excelPath, String excelName, String sheetName) throws IOException {
		ArrayList<String> FieldName = new ArrayList<String>();
		File excel = new File(excelPath + "\\" + excelName);
		FileInputStream readInput = new FileInputStream(excel);
		Workbook workBook = null;
		String excelExtension = excelName.substring(excelName.indexOf("."));

		if (excelExtension.equals(".xlsx")) {
			workBook = new XSSFWorkbook(readInput);
			Sheet testSuite = workBook.getSheet(sheetName);
			int numberOfRows = testSuite.getLastRowNum() - testSuite.getFirstRowNum();
			setRows(numberOfRows);
			for (int i = 1; i < 2; i++) {
				Reporter.log("Reading Columns in Excel");
				Row row = testSuite.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					if (row.getCell(j) != null)
						FieldName.add(j, row.getCell(j).getStringCellValue());
				}
			}
			for (int i = 2; i < numberOfRows + 1; i++) {
				Row row = testSuite.getRow(i);
				int j = 0;
				if (row.getCell(j) != null) {
					Reporter.log("Storing values in Excel");
					origin = row.getCell(j).getStringCellValue();
					Data.put(FieldName.get(j), origin);

					destination = row.getCell(j + 1).getStringCellValue();
					Data.put(FieldName.get(j + 1), destination);

					deliveryDate = row.getCell(j + 2).getStringCellValue();
					Data.put(FieldName.get(j + 2), deliveryDate);

					pickupDate = row.getCell(j + 3).getStringCellValue();
					Data.put(FieldName.get(j + 3), pickupDate);

					commodity = row.getCell(j + 4).getStringCellValue();
					Data.put(FieldName.get(j + 4), commodity);

					product = row.getCell(j + 5).getStringCellValue();
					Data.put(FieldName.get(j + 5), product);

					speed = row.getCell(j + 6).getStringCellValue();
					Data.put(FieldName.get(j + 6), speed);

					shipName = row.getCell(j + 7).getStringCellValue();
					Data.put(FieldName.get(j + 7), shipName);

					shipStreet = row.getCell(j + 8).getStringCellValue();
					Data.put(FieldName.get(j + 8), shipStreet);

					shipCity = row.getCell(j + 9).getStringCellValue();
					Data.put(FieldName.get(j + 9), shipCity);

					shipState = row.getCell(j + 10).getStringCellValue();
					Data.put(FieldName.get(j + 10), shipState);

					shipPostalCode = row.getCell(j + 11).getStringCellValue();
					Data.put(FieldName.get(j + 11), shipPostalCode);

					shipCountry = row.getCell(j + 12).getStringCellValue();
					Data.put(FieldName.get(j + 12), shipCountry);

					consName = row.getCell(j + 13).getStringCellValue();
					Data.put(FieldName.get(j + 13), consName);

					consStreet = row.getCell(j + 14).getStringCellValue();
					Data.put(FieldName.get(j + 14), consStreet);

					consCity = row.getCell(j + 15).getStringCellValue();
					Data.put(FieldName.get(j + 15), consCity);

					consState = row.getCell(j + 16).getStringCellValue();
					Data.put(FieldName.get(j + 16), consState);

					consPostalCode = row.getCell(j + 17).getStringCellValue();
					Data.put(FieldName.get(j + 17), consPostalCode);

					consCountry = row.getCell(j + 18).getStringCellValue();
					Data.put(FieldName.get(j + 18), consCountry);

					noOfPieces = row.getCell(j + 19).getStringCellValue();
					Data.put(FieldName.get(j + 19), noOfPieces);

					grossWeight = row.getCell(j + 20).getStringCellValue();
					Data.put(FieldName.get(j + 20), grossWeight);

					totalVolume = row.getCell(j + 21).getStringCellValue();
					Data.put(FieldName.get(j + 21), totalVolume);

					densityFactor = row.getCell(j + 22).getStringCellValue();
					Data.put(FieldName.get(j + 22), densityFactor);

					awbNumber = row.getCell(j + 23).getStringCellValue();
					Data.put(FieldName.get(j + 23), awbNumber);

					eFright = row.getCell(j + 24).getStringCellValue();
					Data.put(FieldName.get(j + 24), eFright);
					
					phoneTwentyFour = row.getCell(j + 25).getStringCellValue();
					Data.put(FieldName.get(j + 25), phoneTwentyFour);
					
					EmailAddressTwentyFour = row.getCell(j + 26).getStringCellValue();
					Data.put(FieldName.get(j + 26), EmailAddressTwentyFour);
				}
			}
		}
		return Data;
	}
}
