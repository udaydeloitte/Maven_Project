package com.xyzbank.qa.testcases;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ExtebtReport.class)
public class BankmanagerhomeTest extends TestBase {
    Bankmanagerhome objbankmanagerhome;
    Addcustomerdetails objaddcustomerdetails1;
    Loginpage loginpage;
    Openaccountpage objopenacnt;
    Customerspage objcustomers;
    public BankmanagerhomeTest(){
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        objbankmanagerhome=new Bankmanagerhome();
        loginpage=new Loginpage();
        objcustomers=new Customerspage();
        objopenacnt=new Openaccountpage();
        objaddcustomerdetails1=new Addcustomerdetails();
        objbankmanagerhome=loginpage.clickonmanagerlogin();
        Thread.sleep(2000);
    }
    @Test(priority = 1)
    public void addcustomertest() throws InterruptedException {
        objaddcustomerdetails1 = objbankmanagerhome.clickaddcustomer();

    }
    @Test(priority =2)
    public void openaccounttest() throws InterruptedException {
        objopenacnt = objbankmanagerhome.clickonopenaccount();

    }
    @Test(priority = 3)
    public void customerstest() throws InterruptedException {
        objcustomers=objbankmanagerhome.clickcustomers();
    }
    @Test(priority =4)
    public void homebtmtest() throws InterruptedException {
        loginpage=objbankmanagerhome.clickhome();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
