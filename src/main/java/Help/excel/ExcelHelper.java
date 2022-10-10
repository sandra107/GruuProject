package Help.excel;

import Help.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelHelper {
    private Logger log = LoggerHelper.getLogger(ExcelHelper.class);
    private static XSSFSheet excelSheet;
    private static XSSFWorkbook ExcelWBook;


    public Object[][] getTableArray(String FilePath, String SheetName){
        Object[][] tabArray = null;
        try {
            // Tạo đối tượng chứa đường dẫn đến nơi lưu trữ file
            FileInputStream ExcelFile = new FileInputStream(new File(FilePath));
            // Create workbook instance
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            //Get sheet name form workbook
            Sheet excelSheet = ExcelWBook.getSheet(SheetName);
            // Find number of rows in excel file
            int xrows = excelSheet.getLastRowNum();
            System.out.println("rows" + xrows);
            //Tìm cột bằng cách tình từ hàng đầu tiên đến cell cuối cùng
            int xcols=excelSheet.getRow(0).getLastCellNum();
            System.out.println("cols" + xcols);

            tabArray =new String[xrows][xcols];
            int Count=0;
            for(int i=1;i<=xrows; i++)
            {
                Row row=excelSheet.getRow(i);

                for(int j=0; j<xcols;j++)
                {
                    Cell cell= row.getCell(j);
                    String value= cell.toString();
                    tabArray[Count][j]=value;
                }
                Count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return tabArray;
    }

//    public static String getCellData(int RowNum, int ColNum) {
//        try {
//            Cell = excelSheet.getRow(RowNum).getCell(ColNum);
//            int dataType = Cell.getCellType();
//            if (dataType == 3) {
//                return "";
//            } else {
//                String CellData = Cell.getStringCellValue();
//                return CellData;
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw (e);
//        }
//    }

}
