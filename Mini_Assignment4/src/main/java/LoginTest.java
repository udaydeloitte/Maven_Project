import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class LoginTest {
    WebDriver driver;
    @Test
    public void launchBrowser() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\udayprsingh\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
        File file = new File("C:\\Users\\udayprsingh\\IdeaProjects\\Mini_Assignment4\\src\\main\\resources\\DataUser.xlsx");
        System.out.println(file.exists());
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook wb=new HSSFWorkbook(inputStream);
        HSSFSheet sheet=wb.getSheet("Book1");
        HSSFRow row1=sheet.getRow(1);
        HSSFCell cell1=row1.getCell(0);
        HSSFCell cell2=row1.getCell(1);
        String username1=cell1.getStringCellValue();
        String password1=cell2.getStringCellValue();
        WebElement username = driver.findElement(By.xpath("//*[@id='user-name']"));
        username.click();
        username.sendKeys(username1);
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        password.click();
        password.sendKeys(password1);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-button']"));
        loginButton.click();

    }


    }






