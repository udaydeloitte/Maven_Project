package com.xyzbank.qa.testcases;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddcustomerdetailsTest extends TestBase {
    Addcustomerdetails objaddcustomerdetails;
    Loginpage loginpage;
    Bankmanagerhome bankmanagerhome;
    Openaccountpage openaccount;
    Customerspage customerspage;
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
    public void addcustomertest() throws InterruptedException {
        objaddcustomerdetails.addcustomerdata(prop.getProperty("firstname"), prop.getProperty("lastname"),prop.getProperty("postcode"));
        Assert.assertEquals(objaddcustomerdetails.alertmsg,"Customer added successfully with customer id :6");

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
    @Test(priority = 5)
    public void addDuplicateCustomerTest() throws InterruptedException {
        objaddcustomerdetails.addcustomerdata(prop.getProperty("duplicatefname"), prop.getProperty("duplicatelname"), prop.getProperty("duplicatepcode"));
        Assert.assertEquals(objaddcustomerdetails.alertmsg,"Please check the details. Customer may be duplicate.");
    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
