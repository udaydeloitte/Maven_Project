package com.xyzbank.qa.testcases;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.Bankmanagerhome;
import com.xyzbank.qa.pages.Loginpage;
import com.xyzbank.qa.pages.Namepage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginpageTest extends TestBase {
    Loginpage objloginpage;
    Bankmanagerhome objbankmanagerhome;
    Namepage objnamepage;
    public LoginpageTest(){

        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        objloginpage=new Loginpage();
        objbankmanagerhome=new Bankmanagerhome();
        objnamepage= new Namepage();
    }
    @Test(priority = 2)
    public void loginpagetitletest(){
        String title=objloginpage.validateloginpagetitle();
        Assert.assertEquals(title,"XYZ Bank");
    }
    @Test(priority = 1)
    public void managerlogintest() throws InterruptedException {
        objbankmanagerhome=objloginpage.clickonmanagerlogin();
    }
    @Test
    public void customerlogintest() throws InterruptedException {
        objnamepage= objloginpage.clickoncustomerlogin();
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
