package LassanaFlora_POM.utilities;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelTestDataProvider {

    public static List<ExcelTestDataRow> getData() throws Exception {
        List<ExcelTestDataRow> testData = new ArrayList<>();

        try (Workbook workbook = WorkbookFactory.create(new FileInputStream("D:\\IS 4th year\\SQA\\Assignment 2\\Assignment2\\testData.xlsx"))) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                String username = row.getCell(0).getStringCellValue();
                String password = row.getCell(1).getStringCellValue();
                testData.add(new ExcelTestDataRow(username, password));
            }
        }

        return testData;
    }
}

