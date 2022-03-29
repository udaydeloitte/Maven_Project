package com.xyzbank.qa.pages;

import com.xyzbank.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CustomerHome extends TestBase {
    Actions actions=new Actions(driver);
    @FindBy(xpath = "//button[@class='btn logout']")
    WebElement logoutbtn;
    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homebtn;
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement user;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginbtn;
    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement depositBtn;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement field;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement finaldepo;
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement sucess;
    public String msg;
    public CustomerHome(){
        PageFactory.initElements(driver,this);
    }
    public int var=1;
    public CustomerInfo selection(String username, int cnt, double val) throws InterruptedException {
        Select selectuser=new Select(user);
        selectuser.selectByVisibleText(username);
        Thread.sleep(2000);

        loginbtn.click();
        Thread.sleep(2000);
        depositBtn.click();
        Thread.sleep(2000);
        String s=String.valueOf(val);
        field.sendKeys(s);
        Thread.sleep(2000);
        finaldepo.click();
        Thread.sleep(2000);
        msg=sucess.getText();
        logoutbtn.click();
        return new CustomerInfo();


    }



}
