package tests.Practico14.dataProviders.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvidersTests {

    @DataProvider(name = "personas")
    public Object[][] crearPersonas() {
        return new Object[][]{
                {"Juan", new Integer(36), "email@gmail.com"},
                {"Maria", new Integer(37), "test@test.com"},
                {"Julian", new Integer(37), "test@test.com"},
                {"Emiliano", new Integer(37), "test@test.com"},
                {"Ariel", new Integer(37), "test@test.com"},
        };
    }

    @Test(dataProvider = "personas")
    public void datosPersonales(String nombre, int edad, String email) {
        System.out.println("Datos Personales: " + nombre + ". Edad: " + edad + ". Email: " + email);

    }

    @Test(dataProvider = "capitales" , dataProviderClass = dataProviderss.class)
    public void mostrarCapitales(String capitales){
        System.out.println("una capital es " + capitales);
    }
}
