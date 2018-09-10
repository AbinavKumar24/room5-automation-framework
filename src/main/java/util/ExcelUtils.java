package util;

import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author abinav
 *This Utility will fetch the data from Excel sheet
 *
 */
public class ExcelUtils {

    private static final String DATA_FILE_PATH = "/testdata/data.xls";

    private static HSSFSheet excelWSheet;

    private static HSSFWorkbook excelWBook;

    private static HSSFCell cell;

    private static HSSFRow row;

    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    public static void setExcelFile(String sheetName) throws Exception {

        try {

            // Open the Excel file

            InputStream excelFile = ExcelUtils.class.getResourceAsStream(DATA_FILE_PATH);

            // Access the required test data sheet

            excelWBook = new HSSFWorkbook(excelFile);

            excelWSheet = excelWBook.getSheet(sheetName);

        } catch (Exception e){

            throw (e);

        }

    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    public static String getCellData(int RowNum, int ColNum) throws Exception{

        try{

            cell = excelWSheet.getRow(RowNum).getCell(ColNum);

            String CellData = cell.getStringCellValue();

            return CellData;

        }catch (Exception e){

            return"";

        }

    }

}