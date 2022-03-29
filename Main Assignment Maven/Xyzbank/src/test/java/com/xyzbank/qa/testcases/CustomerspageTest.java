package com.xyzbank.qa.testcases;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
@Listeners(ExtebtReport.class)
public class CustomerspageTest extends TestBase {
    Customerspage objcustomer;
    Loginpage loginpage;
    Bankmanagerhome bankmanagerhome;
    Addcustomerdetails objaddcustomer;
    Openaccountpage objopencnt;


    public CustomerspageTest(){
        super();
    }
    @BeforeMethod
    public void setUP() throws InterruptedException {
        initialization();
        objcustomer = new Customerspage();
        loginpage = new Loginpage();
        objaddcustomer =new Addcustomerdetails();
        bankmanagerhome= new Bankmanagerhome();
        bankmanagerhome= loginpage.clickonmanagerlogin();
        objcustomer= bankmanagerhome.clickcustomers();
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void fillvalueTeet() throws InterruptedException, IOException {
        File file = new File("C:\\Users\\udayprsingh\\IdeaProjects\\Xyzbank\\src\\main\\java\\com\\xyzbank\\qa\\testdata\\xyzUserData.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=wb.getSheet("xyzUserData");
        int rows=sheet.getPhysicalNumberOfRows();
        int cols=1;
        String name=null;
        for(int i=1;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (j == 0) {
                    name= sheet.getRow(i).getCell(j).getStringCellValue();
                }
            }
            objcustomer.fillvalue(name);
            System.out.println("Deleted user account: "+name);

        }


    }

    @Test(priority = 1)
    public void addcustomerTest() throws InterruptedException {
        objaddcustomer = objcustomer.addCutomer();
    }
    @Test(priority = 2)
    public void clickhomeTest() throws InterruptedException {
        loginpage = objcustomer.clickhome();
    }
    @Test(priority = 3)
    public void openacntTest() throws InterruptedException {
       objopencnt = objcustomer.clickopenacnt();
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }



}
