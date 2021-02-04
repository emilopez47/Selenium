package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.GetProperties;

import java.io.IOException;
import java.util.List;

public class returnElements {

    private WebDriver driver;

    private void inicializarDriver(String url) throws IOException {
        GetProperties properties = new GetProperties();
        String chromeURL = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emi48\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);

    }

    @Test
    public void retornarH1andH2() throws IOException {

        inicializarDriver("https://www.netflix.com/uy/");
        driver.findElement(By.linkText("Iniciar sesión")).click();

        List<WebElement> listaDeH1 = driver.findElements(By.tagName("h1"));

        for (WebElement lista : listaDeH1) {
            if (listaDeH1.isEmpty() == false) {
                System.out.println("Lista de H1: " + lista.getText());
            }

        }
        List<WebElement> listaDeH2 = driver.findElements(By.tagName("h2"));

        for (WebElement lista2 : listaDeH2) {
            if (listaDeH2.isEmpty() == false) {
                System.out.println("Lista de H2: " + lista2.getText());
            } else {
                System.out.println("No hay H2 en el sitio");

            }
        }

        driver.navigate().back();
        driver.navigate().refresh();

        List<WebElement> listaDiv = driver.findElements(By.tagName("div"));
        System.out.println("Lista de Div del sitio: ");

        for (WebElement lDiv : listaDiv) {
            if (listaDiv.isEmpty() == false) {
                System.out.println(lDiv.getText());
            }
        }

        String title = driver.getTitle();
        System.out.println("El titulo del sitio es : " + title);

        List<WebElement> listLinks = driver.findElements(By.tagName("a"));

        int cantLinks = 0;
        for (WebElement links : listLinks) {

            if (links.getText().isEmpty() == false) {
                System.out.println(links.getText());
                cantLinks++;
            }

        }
        System.out.println("La cantidad de links son : " + cantLinks);
    }


}