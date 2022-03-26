package com.xyzbank.qa.pages;

import com.xyzbank.qa.base.TestBase;
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
    public Addcustomerdetails clickaddcustomer(){
        addcustomer.click();
        return new Addcustomerdetails();
    }
    public Customerspage clickcustomers(){
        customers.click();
        return new Customerspage();
    }
    public Openaccountpage clickonopenaccount(){
        openaccount.click();
        return new Openaccountpage();
    }



}
