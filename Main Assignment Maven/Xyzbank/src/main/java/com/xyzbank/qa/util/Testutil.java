/*package com.xyzbank.qa.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openxml4j.exceptions.InvalidFormatException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Testutil {
    public static String TESTDATA_SHEET_PATH="C:\\Users\\udayprsingh\\IdeaProjects\\Xyzbank\\src\\main\\java\\com\\xyzbank\\qa\\testdata\\xyzUserData.xlsx";
    static Workbook book;
    static Sheet sheet;

    public static Object[][] gettestdata(String sheetName){
        FileInputStream file=null;
        try{
            file=new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book= WorkbookFactory.create(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet=book.getSheet(sheetName);
        Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0;i<sheet.getLastRowNum();i++){
            for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
                data[i][k]=sheet.getRow(i+1).getCell(k).toString();
            }
        }
        return data;
    }
}
*/