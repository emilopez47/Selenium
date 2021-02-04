package tests.Practico9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.GetProperties;

import java.io.IOException;
import java.util.List;

public class clase9_tests {

    private WebDriver driver;

    private void inicializarDriver(String url) throws IOException {
        GetProperties properties = new GetProperties();
        String chromeURL = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\emi48\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    private WebElement inicializarDriver(){
        WebElement un_driver  = (WebElement) new ChromeDriver();
        return un_driver;
    }
    @Test
    public void ejercicio1() throws IOException {
        inicializarDriver("http://www.google.com");

        System.out.println("El titulo del sitio es " + driver.getTitle());
        System.out.println("La URL actual es " + driver.getCurrentUrl());

        Assert.assertEquals(driver.getTitle(), "Google");

        int altura = driver.manage().window().getSize().height;
        int ancho = driver.manage().window().getSize().width;

        System.out.println("El ancho del navegador es " + ancho);
        System.out.println("El alto del navegador es " + altura);

        driver.manage().window().maximize();
        System.out.println("maximizando la pantalla....");
        altura = driver.manage().window().getSize().height;
        ancho = driver.manage().window().getSize().width;

        System.out.println("El ancho del navegador es " + ancho);
        System.out.println("El alto del navegador es " + altura);
        driver.close();
    }

    @Test
    public void buscarEnGoogleTest() throws IOException {
        inicializarDriver("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("que hora es" + Keys.ENTER);
        //driver.close();
        driver.navigate().back();
        driver.navigate().refresh();
        driver.findElement(By.name("q")).sendKeys("que dia es" + Keys.ENTER);

    }


    @Test
    public void mostrarH1sTest() throws IOException {
        inicializarDriver("http://www.booking.com");

        List<WebElement> listaDeH1s = driver.findElements(By.tagName("h1"));
        System.out.println("Los h1 del sitio son: ");

        /*for (int i = 0; i < listaDeH1s.size(); i++){
            System.out.println("--> " + listaDeH1s.get(i).getText());
        }*/

        if (listaDeH1s.isEmpty() == true) {
            System.out.println("NO hay H1 en el sitio");
        } else {
            for (WebElement elemento: listaDeH1s) {
                System.out.println("--> " + elemento.getText());
            }
        }

        List<WebElement> listaDeH2s = driver.findElements(By.tagName("h2"));
        System.out.println("Los h2 del sitio son: ");
        if (listaDeH2s.isEmpty() == true) {
            System.out.println("NO hay H2 en el sitio");
        } else {
            for (WebElement elemento: listaDeH2s) {
                System.out.println("--> " + elemento.getText());
            }
        }

        driver.close();

    }

    @Test
    public void mostrarLinksDelSitio() throws IOException {
        inicializarDriver("http://www.booking.com");

        List<WebElement> linksDelSitio = driver.findElements(By.tagName("a"));
        System.out.println("Los links del sitio son: ");
        for (WebElement link : linksDelSitio){
            if (link.getText().isEmpty() == false ) {
                System.out.println("*** " + link.getText());
            }
        }

        driver.close();
    }

    @Test
    public void mostrarParrafosyBotonesDelSitioTest() throws IOException {
        inicializarDriver("http://www.booking.com");

        List<WebElement> parrafos = driver.findElements(By.tagName("p"));
        System.out.println("Los parrafos del sitio son: ");
        for (WebElement parrafo : parrafos){
            try {
                System.out.println("*** " + parrafo.getText());
            } catch (Exception ex) {
                System.out.println("Ha ocurrido una excepcion " + ex.getMessage());
            }
        }

        driver.close();
    }

    @Test
    public void mostrarBotonesDelSitioTest() throws IOException {
        inicializarDriver("http://www.booking.com");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("Los botones del sitio son: ");
        for (WebElement btn : buttons){
            try {
                System.out.println("*** " + btn.getText());
            } catch (Exception ex) {
                System.out.println("Ha ocurrido una excepcion " + ex.getMessage());
            }
        }

        driver.close();
    }




}