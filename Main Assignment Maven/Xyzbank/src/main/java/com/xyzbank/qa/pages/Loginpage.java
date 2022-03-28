package com.xyzbank.qa.pages;

import com.xyzbank.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends TestBase {
    //Page Factory- OR;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[2]/button")
    WebElement bankmanager;

    @FindBy(xpath = "//button[text()='Customer Login']")
    WebElement cutomer;
    //initialize page objects
    public Loginpage(){
        PageFactory.initElements(driver,this);

    }
    //actions
    public String validateloginpagetitle(){

        return driver.getTitle();
    }
    public Bankmanagerhome clickonmanagerlogin() throws InterruptedException {
        Thread.sleep(2000);
        bankmanager.click();

        return new Bankmanagerhome();

    }
    public Namepage clickoncustomerlogin() throws InterruptedException {
        Thread.sleep(2000);
        cutomer.click();
        Thread.sleep(2000);
        return new Namepage();
    }





}
