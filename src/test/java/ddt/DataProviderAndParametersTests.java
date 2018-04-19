package ddt;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.XlsDataProvider;

public class DataProviderAndParametersTests {

    @Test(dataProviderClass = XlsDataProvider.class, dataProvider = "xls_provider")
    public void testWithDataProvider(String firstName, String lastName){
        Reporter.log(String.format("Test with data provider: firstName - %s, lastName - %s",
                firstName, lastName), true);
    }

    @Parameters({"parameter_from_xml"})
    @Test
    public void testWithParameterFromXml(String parameter)
    {
        Reporter.log(String.format("Test with parameter from xml = %s", parameter), true);
    }
}