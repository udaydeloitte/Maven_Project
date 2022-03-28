package com.xyzbank.qa.pages;

import com.xyzbank.qa.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customerspage extends TestBase {
    Actions actions=new Actions(driver);
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement inputCustomer;

    @FindBy(xpath = "//button[text()='Delete']")
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
        Thread.sleep(1000);
        deleteBtn.click();
        Thread.sleep(1000);
        actions.click(inputCustomer).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
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

