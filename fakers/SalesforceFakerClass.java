package tests.Practico14.fakers;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SalesforceFakerClass {

    WebDriver driver;
    private static Faker FAKER = new Faker();

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emi48\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.salesforce.com/mx/form/signup/freetrial-sales-pe/?d=70130000000EqoP");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void fillingForms() throws InterruptedException {

        String firstName = FAKER.name().firstName();
        String lastName = FAKER.name().lastName();
        String address = FAKER.address().fullAddress();
        String jobTitle = FAKER.job().title();
        String email = FAKER.internet().emailAddress();

        driver.findElement(By.name("UserFirstName")).sendKeys(firstName);
        driver.findElement(By.name("UserLastName")).sendKeys(lastName);
        driver.findElement(By.name("UserTitle")).sendKeys(jobTitle);
        driver.findElement(By.name("UserEmail")).sendKeys(email);


    }

}
