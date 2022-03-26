package com.xyzbank.qa.base;

import com.xyzbank.qa.util.Testutil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase(){
        try{
            prop=new Properties();
            FileInputStream ip=new FileInputStream("C:\\Users\\udayprsingh\\IdeaProjec" +
                    "ts\\Xyzbank\\src\\main\\java\\com\\xyzbank\\qa\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initialization(){
        String browserName=prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\udayprsingh\\Downloads\\chromedriver.exe");
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Testutil.implicit,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
