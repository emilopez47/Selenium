package tests.Practico14.dataProviders.DataProvider;

import org.testng.annotations.DataProvider;

public class dataProviderss {

    @DataProvider(name = "capitales")
    public Object[][] cargarCapitales() {
        return new Object[][]{
                {"Montevideo"}, {"Buenos Aires"}
        };
    }
    @DataProvider(name = "saleforceRegistrationFiel")
    public Object[][] registrarFields() {
        return new Object[][]{
                {"Alan","Smith", "QA", "alan@qa.com"},
                {"John","Prex", "Dev Sr", "johnn@dev.com"},
                {"Brianne","Eastburn", "Qa Sr", "Brianne@qa.com"},
                {"Dann","Toll", "Business Analyst", "dann@ba.com"},

        };
    }

}
