package com.xyzbank.qa.testcases;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    @Test
    public void fillvalueTeet() throws InterruptedException {
        objcustomer.fillvalue(prop.getProperty("firstname"));
    }
    @Test
    public void fillvalueDTeet() throws InterruptedException {
        objcustomer.fillvalue(prop.getProperty("duplicatefname"));
    }
    @Test
    public void addcustomerTest() throws InterruptedException {
        objaddcustomer = objcustomer.addCutomer();
    }
    @Test
    public void clickhomeTest() throws InterruptedException {
        loginpage = objcustomer.clickhome();
    }
    @Test
    public void openacntTest() throws InterruptedException {
       objopencnt = objcustomer.clickopenacnt();
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }



}
