package com.xyzbank.qa.testcases;

import com.xyzbank.qa.base.TestBase;
import com.xyzbank.qa.pages.Addcustomerdetails;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddcustomerdetailsTest extends TestBase {
    Addcustomerdetails objaddcustomerdetails;

    public AddcustomerdetailsTest(){
        super();
    }
    @BeforeMethod
    public void setUP(){
        initialization();
        objaddcustomerdetails=new Addcustomerdetails();

    }
    @Test
    public void addcustomertest() throws InterruptedException {
        objaddcustomerdetails.addcustomerdata(prop.getProperty("firstname"), prop.getProperty("lastname"),prop.getProperty("postcode"));
        Assert.assertEquals(objaddcustomerdetails.alertmsg,"Customer added successfully with customer id:7");

    }


    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
