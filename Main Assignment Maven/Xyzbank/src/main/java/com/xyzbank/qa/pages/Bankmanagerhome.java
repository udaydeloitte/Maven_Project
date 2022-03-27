package com.xyzbank.qa.pages;

import com.xyzbank.qa.base.TestBase;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bankmanagerhome extends TestBase {
    //Page Factory- OR;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[1]")
    WebElement addcustomer;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[2]")
    WebElement openaccount;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement customers;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homebtn1;


    public Bankmanagerhome(){

        PageFactory.initElements(driver,this);
    }
    public Addcustomerdetails clickaddcustomer() throws InterruptedException {
        Thread.sleep(2000);
        addcustomer.click();
        Thread.sleep(2000);
        return new Addcustomerdetails();
    }
    public Customerspage clickcustomers() throws InterruptedException {
        Thread.sleep(2000);
        customers.click();
        Thread.sleep(2000);
        return new Customerspage();

    }
    public Openaccountpage clickonopenaccount() throws InterruptedException {
        Thread.sleep(2000);
        openaccount.click();
        Thread.sleep(2000);
        return new Openaccountpage();
    }
    public Loginpage clickhome() throws InterruptedException {
        Thread.sleep(2000);
        homebtn1.click();
        Thread.sleep(2000);
        return new Loginpage();
    }



}
