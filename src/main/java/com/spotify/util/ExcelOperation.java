package com.spotify.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.qameta.allure.Step;

public final class ExcelOperation {
	private XSSFWorkbook workbook;
	private File excelfile;
	private XSSFSheet sheet;

	public ExcelOperation(String path) {
		this.excelfile = new File(path);
	}

	@Step("Reading readAll")
	public ArrayList<HashMap<String, Object>> readAll(int sheetno) {
		ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();

		try {
			FileInputStream inputStream = new FileInputStream(excelfile);
			workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = this.workbook.getSheetAt(sheetno);
			String key = null;
			Object value = null;
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				HashMap<String, Object> map = new HashMap<String, Object>();
				for (int j = 0; j <= sheet.getRow(i).getLastCellNum(); j++) {
					key = (String) readcell(sheet, 0, j);
					value = readcell(sheet, i, j);

					map.put(key, value);
				}
				data.add(map);
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return data;
	}

	@Step("Reading readAll")
	public Object[][] readInArray(int sheetno) {
		Object[][] data = null;
		try {
			FileInputStream inputStream = new FileInputStream(excelfile);
			workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = this.workbook.getSheetAt(sheetno);
			data = new Object[sheet.getLastRowNum()][];
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				for (int j = 0; j <= sheet.getRow(i).getLastCellNum(); j++) {
					data[i][j] = readcell(sheet, i, j);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return data;
	}

	@Step("Reading testcase")
	public HashMap<String, Object> read(int sheetno, int rowNum) {
		HashMap<String, Object> map = null;
		try {
			FileInputStream inputStream = new FileInputStream(excelfile);
			workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = this.workbook.getSheetAt(sheetno);
			String key = null;
			Object value = null;
			map = new HashMap<String, Object>();
			for (int j = 0; j <sheet.getRow(rowNum).getLastCellNum(); j++) {
				key = (String) readcell(sheet, 0, j);
				value = readcell(sheet, rowNum, j);
				map.put(key, value);
			}
			// inputStream.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return map;
	}

	@Step("writing testcase")
	public boolean writecell(int sheetno, String value, int row, int column) {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(excelfile);
			sheet = workbook.getSheetAt(sheetno);
			try {
				sheet.getRow(row).createCell(column).setCellValue(value);
			} catch (Exception e) {
				System.out.println(sheetno + "\t" + value + "\t" + row + "\t" + column);
				e.printStackTrace();
			}
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public Object readcell(Sheet sheet, int i, int j) {
		Cell cell = sheet.getRow(i).getCell(j);
		Object value = "";
		try {
			switch (cell.getCellType()) {
			case STRING:
				value = cell.getStringCellValue();
				break;
			case NUMERIC:
				value = cell.getNumericCellValue();
				break;
			case BOOLEAN:
				value = cell.getBooleanCellValue();
				break;
			default:
				break;
			}
		} catch (Exception e1) {
			System.out.println("Reading data from cell");
			System.out.println(e1);
		}
		return value;
	}
}
