package com.xyzbank.qa.pages;

import com.xyzbank.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfo extends TestBase {
    @FindBy(xpath = "//button[@class='btn logout']")
    WebElement logoutBtn;
    public CustomerInfo(){
        PageFactory.initElements(driver,this);
    }
    public CustomerHome loggingout(){
        logoutBtn.click();
        return new CustomerHome();
    }


}
