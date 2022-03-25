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
        File file = new File("C:\\Users\\udayprsingh\\IdeaProjects\\Mini_Assignment4\\src\\main\\resources\\DataUser.xls");
        System.out.println(file.exists());
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook wb=new HSSFWorkbook(inputStream);
        HSSFSheet sheet=wb.getSheet("Sheet1");
        int rows=sheet.getPhysicalNumberOfRows();
        int cols=sheet.getRow(0).getLastCellNum();
        String email=null;
        String pass=null;
        for(int i=1;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (j==0){
                    email=sheet.getRow(i).getCell(j).getStringCellValue();
                }
                if(j==1){
                    pass=sheet.getRow(i).getCell(j).getStringCellValue();
                }
                    //System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
            }
                driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(email);
                driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
                Thread.sleep(1000);


        }
        wb.close();
        inputStream.close();
        WebElement sort = driver.findElement(By.xpath("//*[@id='header_container']//span/select"));
        sort.click();
        Thread.sleep(3000);
        WebElement HighToLow = driver.findElement(By.xpath("//*[@id='header_container']//select/option[4]"));
        HighToLow.click();
        Thread.sleep(3000);
        WebElement HighestPricedProduct = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-fleece-jacket']"));
        HighestPricedProduct.click();
        Thread.sleep(3000);




    }


    }






