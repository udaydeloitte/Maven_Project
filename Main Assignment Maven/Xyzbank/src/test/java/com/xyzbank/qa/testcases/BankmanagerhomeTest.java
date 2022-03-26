package com.xyzbank.qa.testcases;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.Addcustomerdetails;
import com.xyzbank.qa.pages.Bankmanagerhome;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankmanagerhomeTest extends TestBase {
    Bankmanagerhome objbankmanagerhome;
    Addcustomerdetails objaddcustomerdetails1;
    public BankmanagerhomeTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        objbankmanagerhome=new Bankmanagerhome();
    }
    @Test
    public void addcustomertest(){
        objaddcustomerdetails1 = objbankmanagerhome.clickaddcustomer();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
