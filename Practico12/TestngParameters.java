package tests.Practico12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class TestngParameters {
    private final String SPOTIFY_URL = "http://www.spotify.com/uy/";
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emi48\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(SPOTIFY_URL);
    }

    @Test
    @Parameters({"specificTag"})
    public void printTagNameTest(@Optional("button") String tag) {
        List<WebElement> tagList = driver.findElements(By.tagName(tag));
        if (tagList.isEmpty() == false) {
            if (tag.equals("h1")) {
                System.out.println("Se imprimiran los h1");
            }
            if (tag.equals("h2")) {
                System.out.println("Se imprimiran los h2");
            }

            if (tag.equals("a")) {
                System.out.println("Se imprimiran los hipervinculos");
            }
        }
        else{
            System.out.println("La lista se encuentra vacia");
        }

        for (WebElement e : tagList) {

            System.out.println(e.getText());
        }

    }


}

