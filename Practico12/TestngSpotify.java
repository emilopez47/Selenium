package tests.Practico12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngSpotify {

    private WebDriver driver;
    private final String SPOTIFY_TITLE = "Escuchar es todo - Spotify";
    private final String SPOTIFY_URL = "http://www.spotify.com/uy/";


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emi48\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(SPOTIFY_URL);
    }

    @Test
    public void verifySportifyTitleTest() {
        Assert.assertEquals(driver.getTitle(), SPOTIFY_TITLE);
    }

    @Test
    public void verifySignupUrl() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div/nav/ul/li[5]/a")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"));
    }

    @Test
    public void invalidEmailTest() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div/nav/ul/li[5]/a")).click();
        driver.findElement(By.id("email")).sendKeys("test.com");
        driver.findElement(By.xpath("//*[@id='confirm']")).sendKeys("test.com");
        Thread.sleep(3000);
        WebElement invalidEmailError = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com')]"));
        Assert.assertEquals(invalidEmailError.getText(), "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");

    }


    @AfterMethod
    public void close() {
        //driver.close();
    }

}
