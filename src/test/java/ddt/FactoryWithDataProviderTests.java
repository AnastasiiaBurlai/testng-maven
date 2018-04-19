package ddt;

import org.testng.Reporter;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import utils.XlsDataProvider;

public class FactoryWithDataProviderTests {

    private String param;

    @Factory(dataProviderClass = XlsDataProvider.class, dataProvider = "xls_provider_factory")
    public FactoryWithDataProviderTests(String param) {
        this.param = param;
    }

    @Test
    public void testFactoryWithDataProvider1() {
        Reporter.log(String.format("Test1 factory with data provider: %s 1", param), true);
    }

    @Test
    public void testFactoryWithDataProvider2() {
        Reporter.log(String.format("Test1 factory with data provider: %s 2", param), true);
    }
}
