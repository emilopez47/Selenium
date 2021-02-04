package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Priorities {

    /*Crear un método llamado método LoginFailureTest
En el sitio de salesforce: "https://login.salesforce.com/?locale=eu"
Validar que se encuentre el logo en el sitio (utilizar un WebElement)
Completar el username con “test@test.com”
Completar el campo Password con “123466”
Hacer click en Login
Imprimir en pantalla el mensaje de error
El orden de prioridad de este test, debe ser 3/*
*/

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emi48\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test(priority = 3)
    public void LoginFailureTest(){
        driver.get("https://login.salesforce.com/?locale=eu");
        WebElement logoActual = driver.findElement(By.id("logo"));
        Assert.assertEquals(driver.findElement(By.id("logo")),logoActual);
        driver.findElement(By.id("username")).sendKeys("test@test.com");
        driver.findElement(By.name("pw")).sendKeys("t132456");
        driver.findElement(By.id("Login")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(),'Your access to salesforce.com has been disabled by your system administrator. Please contact your Administrator for more information.')]"));
        System.out.println(errorMessage.getText());
        String expectedMessageError = "Your access to salesforce.com has been disabled by your system administrator. Please contact your Administrator for more information.";

        Assert.assertEquals(expectedMessageError,errorMessage.getText());
    }




}
