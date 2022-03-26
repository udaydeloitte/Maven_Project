package com.xyzbank.qa.pages;

import com.xyzbank.qa.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addcustomerdetails extends TestBase {
    //Page Factory- OR;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstname;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastname;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postcode;

    @FindBy(xpath = "//button[text()='Add Customer']")
    WebElement addcustomerbtn;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homebtn;

    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openaccountbtn;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement customersbtn;
    public String alertmsg;
    //initialize page objects
    public Addcustomerdetails(){
        PageFactory.initElements(driver,this);

    }
    public void addcustomerdata(String fname, String ln, String pcode) throws InterruptedException {
        firstname.sendKeys(fname);
        lastname.sendKeys(ln);
        postcode.sendKeys(pcode);
        addcustomerbtn.click();
        Alert simplealert=driver.switchTo().alert();
        alertmsg= simplealert.getText();
        Thread.sleep(2000);
        simplealert.accept();
    }


}
