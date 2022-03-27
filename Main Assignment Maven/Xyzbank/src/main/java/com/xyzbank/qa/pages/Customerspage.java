package com.xyzbank.qa.pages;

import com.xyzbank.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customerspage extends TestBase {
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement inputCustomer;

    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    WebElement deleteBtn;

    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addcustomer;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homebn;

    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openbtn;

    public Customerspage(){
        PageFactory.initElements(driver,this);
    }
    public void fillvalue(String username) throws InterruptedException{
        inputCustomer.sendKeys(username);
        Thread.sleep(2000);
        deleteBtn.click();
        Thread.sleep(1000);
    }
    public Addcustomerdetails addCutomer() throws InterruptedException {
        addcustomer.click();
        Thread.sleep(2000);
        return new Addcustomerdetails();
    }
    public Loginpage clickhome() throws InterruptedException {
        homebn.click();
        Thread.sleep(2000);
        return new Loginpage();
    }
    public Openaccountpage clickopenacnt() throws InterruptedException {
        openbtn.click();
        Thread.sleep(2000);
        return new Openaccountpage();
    }

}

