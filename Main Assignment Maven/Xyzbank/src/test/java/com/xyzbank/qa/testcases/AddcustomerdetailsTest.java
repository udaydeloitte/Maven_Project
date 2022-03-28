package com.xyzbank.qa.testcases;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AddcustomerdetailsTest extends TestBase {
    Addcustomerdetails objaddcustomerdetails;
    Loginpage loginpage;
    Bankmanagerhome bankmanagerhome;
    Openaccountpage openaccount;
    Customerspage customerspage;
    String sheetName="xyzUserData";
    public AddcustomerdetailsTest(){
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
        objaddcustomerdetails=bankmanagerhome.clickaddcustomer();
        Thread.sleep(2000);

    }

    @Test(priority = 1)
    public void addcustomerdataTEST() throws IOException, InterruptedException {
        File file = new File("C:\\Users\\udayprsingh\\IdeaProjects\\Xyzbank\\src\\main\\java\\com\\xyzbank\\qa\\testdata\\xyzUserData.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=wb.getSheet("xyzUserData");
        int rows=sheet.getPhysicalNumberOfRows();
        int cols=sheet.getRow(0).getLastCellNum();
        String first=null;
        String last=null;
        String postcode=null;
        for(int i=1;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    first= sheet.getRow(i).getCell(j).getStringCellValue();
                }
                if (j == 1) {
                    last= sheet.getRow(i).getCell(j).getStringCellValue();
                }
                if(j==2){
                    postcode=sheet.getRow(i).getCell(j).getStringCellValue();
                }

            }
            System.out.println(first+" "+last+" "+postcode);
            objaddcustomerdetails.addcustomerdata(first,last,postcode);
            System.out.println(objaddcustomerdetails.alertmsg);
            objaddcustomerdetails.customebtn();
            customerspage.addCutomer();
        }
        wb.close();
        inputStream.close();
    }

    @Test(priority =2)
    public void homebtmtest() throws InterruptedException {
        loginpage= objaddcustomerdetails.clickhomebtn();

    }
    @Test(priority = 3)
    public void accountbtntest() throws InterruptedException {
        openaccount=objaddcustomerdetails.accountbtn();
    }
    @Test(priority = 4)
    public void customerbtntest() throws InterruptedException {
        customerspage=objaddcustomerdetails.customebtn();
    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
