package com.xyzbank.qa.testcases;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    @Test(priority = 1)
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




    @AfterMethod
    public void tearDown(){

        driver.quit();
    }



}
