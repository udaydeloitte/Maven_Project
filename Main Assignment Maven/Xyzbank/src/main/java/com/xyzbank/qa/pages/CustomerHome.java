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
    public CustomerHome(){
        PageFactory.initElements(driver,this);
    }
    public int var=1;
    public CustomerInfo selection(String username, int cnt, double val) throws InterruptedException {
        Select selectuser=new Select(user);
        selectuser.selectByVisibleText(username);
        Thread.sleep(2000);
        actions.click(user).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();

        var++;
        if(var==cnt) {
            loginbtn.click();
            Thread.sleep(1000);
            depositBtn.click();
            Thread.sleep(2000);
            String s=String.valueOf(val);
            field.sendKeys(s);


        }
        return new CustomerInfo();


    }



}
