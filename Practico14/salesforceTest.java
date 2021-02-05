package tests.Practico14.dataProviders.DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class salesforceTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emi48\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/mx/form/signup/freetrial-sales-pe/?d=70130000000EqoP");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    @Test (dataProvider = "saleforceRegistrationFiel", dataProviderClass = dataProviderss.class)
    public void registrationTest(String name, String surname, String title, String email){

        driver.findElement(By.name("UserFirstName")).sendKeys(name);
        driver.findElement(By.name("UserLastName")).sendKeys(surname);
        driver.findElement(By.name("UserTitle")).sendKeys(title);
        driver.findElement(By.name("UserEmail")).sendKeys(email);

    }

}






