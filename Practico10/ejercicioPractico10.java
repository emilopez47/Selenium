package tests.Practico10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.GetProperties;

import java.io.IOException;

public class ejercicioPractico10 {

    private WebDriver getDriver(String url) throws IOException {
        GetProperties properties = new GetProperties();
        String chromeDriverUrl = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emi48\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        return driver;
    }


    @Test
    public void forgotAccountTest() throws IOException, InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com");

        System.out.println("drivvv " + driver.getTitle());
        driver.findElement(By.partialLinkText("¿Has olvidado la contraseña?")).click();

        String actualTitle = driver.getTitle();
        Thread.sleep(3000);

        Assert.assertEquals(actualTitle, "¿Has olvidado la contraseña? | No puedo entrar | Facebook",
                "Se deberia estar en la sección de olvidaste contraseña");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.facebook.com/",
                "Se deberia estar en otra URL");
        driver.close();
    }

    @Test
    public void forgotAccountPartialLinkTest() throws IOException {
        WebDriver driver = getDriver("https://www.facebook.com");
        driver.findElement(By.partialLinkText("¿Has olvidado")).click();

        Assert.assertEquals(driver.getTitle(),
                "¿Has olvidado la contraseña? | No puedo entrar | Facebook",
                "Se deberia estar en la sección de olvidaste contraseña");
    }

    @Test
    public void customSalesforceLinkTest() throws InterruptedException, IOException {
        WebDriver driver = getDriver("https://login.salesforce.com/");
        //driver.findElement(By.id("mydomainLink")).click();
        driver.findElement(By.linkText("Utilizar dominio personalizado")).click();
        driver.findElement(By.name("mydomain")).sendKeys("as");
        driver.findElement(By.id("mydomainContinue")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("okta-signin-username")).sendKeys("test@test.com");
    }

    @Test
    public void checkBoxAndComboboxTest() throws InterruptedException, IOException {
        WebDriver driver = getDriver("https://facebook.com/");

        driver.findElement(By.id("u_0_2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("u_1_4")).click();

        driver.findElement(By.name("firstname")).sendKeys("Alan");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        WebElement dias = driver.findElement(By.id("day"));
        Select comboboxDias = new Select(dias);
        comboboxDias.selectByValue("4");

        WebElement mes = driver.findElement(By.id("month"));
        Select comboboxMeses = new Select(mes);
        comboboxMeses.selectByVisibleText("abr");

        WebElement año = driver.findElement(By.id("year"));
        Select comboboxAño = new Select(año);
        comboboxAño.selectByIndex(9);

    }


}