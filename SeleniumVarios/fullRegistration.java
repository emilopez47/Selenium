package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.GetProperties;

import java.io.IOException;

public class fullRegistration {

    private WebDriver driver;

    private void inicializarDriver(String url) throws IOException {
        GetProperties properties = new GetProperties();
        String chromeURL = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emi48\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test
    public void fullRegistrationTest() throws IOException, InterruptedException {

        inicializarDriver("https://www.facebook.com/");
        driver.findElement(By.id("u_0_2")).click();
        Thread.sleep(7000);
        driver.findElement(By.id("u_2_3")).click();
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("55555555");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");

        WebElement dias = driver.findElement(By.id("day"));
        Select comboBoxDias = new Select(dias);
        comboBoxDias.selectByValue("26");

        WebElement meses = driver.findElement(By.id("month"));
        Select comboBoxMes = new Select(meses);
        comboBoxMes.selectByValue("6");

        WebElement años = driver.findElement(By.id("year"));
        Select comboBoxAños = new Select(años);
        comboBoxAños.selectByValue("1980");
    }

}