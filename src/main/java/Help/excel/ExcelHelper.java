package Help.excel;

import Help.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExcelHelper {
    private Logger log = LoggerHelper.getLogger(ExcelHelper.class);
    private static XSSFSheet excelSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    public Object[][] getTableArray(String FilePath, String SheetName) throws Exception {
        Object[][] tabArray = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(new File(FilePath));
            // Create workbook instance
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            //Get sheet name form workbook
            excelSheet = ExcelWBook.getSheet(SheetName);
            // Find number of rows in excel file
            System.out.println("First Row Number/index:"+ excelSheet.getFirstRowNum() + " *** Last Row Number/index:"
                    + excelSheet.getLastRowNum());

            int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum()+1;
            int colCount = excelSheet.getRow(0).getLastCellNum();
            System.out.println("Row Count is: " + rowCount
                    + " *** Column count is: " + colCount);
            Object[][] data = new Object[rowCount][colCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    // Call 'getStringCellValue()' here instead of using just 'getCell()'
                    data[i][j] = excelSheet.getRow(1).getCell(j).getStringCellValue().trim();
                }
            }

//            int startRow = 1;
//            int startCol = 1;
//            int ci, cj;
//            int totalRows = ExcelWSheet.getLastRowNum();
//            // you can write a function as well to get Column count
//            int totalCols = 2;
//            tabArray = new String[totalRows][totalCols];
//            ci = 0;
//            for (int i = startRow; i <= totalRows; i++, ci++) {
//                cj = 0;
//                for (int j = startCol; j <= totalCols; j++, cj++) {
//                    tabArray[ci][cj] = getCellData(i, j);
//                    System.out.println(tabArray[ci][cj]);
//                }
//            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);
    }

    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            Cell = excelSheet.getRow(RowNum).getCell(ColNum);
            int dataType = Cell.getCellType();
            if (dataType == 3) {
                return "";
            } else {
                String CellData = Cell.getStringCellValue();
                return CellData;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw (e);
        }
    }

}
