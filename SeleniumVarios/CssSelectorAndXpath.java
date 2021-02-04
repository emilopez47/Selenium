package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.GetProperties;

import java.io.IOException;

public class CssSelectorAndXpath {

    private WebDriver driver;

    private void inicializarDriver(String url) throws IOException {
        GetProperties properties = new GetProperties();
        String chromeURL = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emi48\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }
    @Test
    public void spotifyByPlaceHolder() throws IOException, InterruptedException {

        inicializarDriver("https://www.spotify.com/uy/signup");

        driver.findElement(By.cssSelector("input[placeholder = 'Introduce tu correo electrónico.']")).sendKeys("emi48484848@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder = 'Vuelve a introducir tu correo electrónico.']")).sendKeys("emi48484848@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder = 'Crea una contraseña.']")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input[placeholder = 'Introduce un nombre de perfil.']")).sendKeys("emilopez");
        driver.findElement(By.cssSelector("input[placeholder = 'DD']")).sendKeys("25");
        Select dprMes = new Select(driver.findElement(By.id("month")));
        dprMes.selectByVisibleText("Marzo");
        driver.findElement(By.cssSelector("input[placeholder = 'AAAA']")).sendKeys("1992");
        driver.findElement(By.xpath("//span[@class='Indicator-sc-16vj7o8-0 kSKYRE']")).click();

    }
}
