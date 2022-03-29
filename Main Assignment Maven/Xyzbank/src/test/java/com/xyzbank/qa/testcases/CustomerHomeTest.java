package com.xyzbank.qa.testcases;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.CustomerHome;
import com.xyzbank.qa.pages.CustomerInfo;
import com.xyzbank.qa.pages.Loginpage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
@Listeners(ExtebtReport.class)
public class CustomerHomeTest extends TestBase {
    CustomerHome objCustomerHome;
    Loginpage objlogin;
    CustomerInfo objcusinfo;
    public CustomerHomeTest(){
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        objcusinfo=new CustomerInfo();
        objCustomerHome=new CustomerHome();
        objlogin=new Loginpage();
        objlogin.clickoncustomerlogin();
        Thread.sleep(2000);

    }

    @Test
    public void enteruser() throws IOException, InterruptedException {
        File file = new File("C:\\Users\\udayprsingh\\IdeaProjects\\Xyzbank\\src\\main\\java\\com\\xyzbank\\qa\\testdata\\CustomerData.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=wb.getSheet("CustomerData");
        int rows=sheet.getPhysicalNumberOfRows();
        int cols=sheet.getRow(0).getLastCellNum();
        String customerName=null;
        double val=1;
        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                if (j == 0) {
                    customerName= sheet.getRow(i).getCell(j).getStringCellValue();
                }
                if(j==2){
                    val=sheet.getRow(i).getCell(j).getNumericCellValue();
                }


            }
            System.out.println(customerName);
            objCustomerHome.selection(customerName,rows,val);
        }
        wb.close();
        inputStream.close();
    }





    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
