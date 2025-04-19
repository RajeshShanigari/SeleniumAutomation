package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private static final String EXCEL_PATH = "src/test/resources/TestData.xlsx";

    public String getCellData(int rowNum, int colNum) {
        try (FileInputStream fis = new FileInputStream(EXCEL_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(rowNum);

            if (row == null) return null;

            Cell cell = row.getCell(colNum);
            if (cell == null) return null;

            return cell.toString().trim();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read Excel file at row: " + rowNum + ", col: " + colNum);
        }
    }
}