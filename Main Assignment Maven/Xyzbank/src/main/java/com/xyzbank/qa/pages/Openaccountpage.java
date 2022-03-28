package com.xyzbank.qa.pages;

import com.xyzbank.qa.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Openaccountpage extends TestBase {
    //Page Factory- OR;
    @FindBy(xpath = "//button[@class='btn home']")
    WebElement btnhome;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement customersbtn;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement processbtn;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement userselect;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currency;

    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addcustomer;
    public String altmsg;

    public Openaccountpage(){
        PageFactory.initElements(driver,this);
    }
    public Customerspage customerbtnclick() throws InterruptedException {
        customersbtn.click();
        Thread.sleep(2000);
        return new Customerspage();
    }

    public Loginpage homeBtnClick() throws InterruptedException {
        btnhome.click();
        Thread.sleep(2000);
        return new Loginpage();
    }

    public Addcustomerdetails clickaddcustomer() throws InterruptedException {
        addcustomer.click();
        Thread.sleep(2000);
        return new Addcustomerdetails();

    }
    public void userdraopdown(String name,String currencyuser) throws InterruptedException {
        Select selectuser=new Select(userselect);
        selectuser.selectByVisibleText(name);
        Thread.sleep(2000);
        Select selectcurrency=new Select(currency);
        selectcurrency.selectByVisibleText(currencyuser);
        processbtn.click();
        Alert simplealert=driver.switchTo().alert();
        altmsg= simplealert.getText();
        simplealert.accept();
        Thread.sleep(2000);

    }

}

