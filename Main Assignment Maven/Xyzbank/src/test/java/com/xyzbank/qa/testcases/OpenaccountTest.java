package com.xyzbank.qa.testcases;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class OpenaccountTest extends TestBase {
    Addcustomerdetails objaddcustomerdetails;
    Loginpage loginpage;
    Bankmanagerhome bankmanagerhome;
    Openaccountpage openaccount;
    Customerspage customerspage;
    public OpenaccountTest(){

        super();
    }
    @BeforeMethod
    public void setUP() throws InterruptedException {
        initialization();
        objaddcustomerdetails=new Addcustomerdetails();
        loginpage=new Loginpage();
        openaccount=new Openaccountpage();
        bankmanagerhome=new Bankmanagerhome();
        customerspage=new Customerspage();
        bankmanagerhome=loginpage.clickonmanagerlogin();
        openaccount=bankmanagerhome.clickonopenaccount();
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void clickCustomersTest() throws InterruptedException {
        customerspage=openaccount.customerbtnclick();
    }
    @Test(priority = 2)
    public void clickhomeTest() throws InterruptedException {
        loginpage=openaccount.homeBtnClick();
    }
    @Test(priority = 3)
    public void clickaddcustomerTest() throws InterruptedException {
        objaddcustomerdetails=openaccount.clickaddcustomer();
    }
    @Test(priority = 1)
    public void userdropdownTest() throws InterruptedException, IOException {
        File file = new File("C:\\Users\\udayprsingh\\IdeaProjects\\Xyzbank\\src\\main\\java\\com\\xyzbank\\qa\\testdata\\CustomerData.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=wb.getSheet("CustomerData");
        int rows=sheet.getPhysicalNumberOfRows();
        int cols=sheet.getRow(0).getLastCellNum();
        String customerName=null;
        String currency=null;
        for (int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                if (j == 0) {
                    customerName= sheet.getRow(i).getCell(j).getStringCellValue();
                }
                if (j == 1) {
                    currency= sheet.getRow(i).getCell(j).getStringCellValue();
                }
            }
            System.out.println(customerName+" "+currency);
            openaccount.userdraopdown(customerName,currency);
            System.out.println(openaccount.altmsg);
        }
        wb.close();
        inputStream.close();
    }



    @AfterMethod
    public void tearDown(){

        driver.quit();
    }



}
