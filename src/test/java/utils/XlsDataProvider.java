package utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class XlsDataProvider {

    private static Object[][] getDataFromXls(String workBookName, String sheetName, int numberOfParameters){
        InputStream xlsFile = XlsDataProvider.class.getClassLoader()
                .getResourceAsStream(String.format("xls/%s.xlsx", workBookName));
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(xlsFile);
            return XlsReader.read(workbook.getSheet(sheetName), 0, numberOfParameters);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @DataProvider(name = "xls_provider")
    public static Object[][] getTestData(Method testMethod) {
        String testMethodName = testMethod.getName();
        String testClassName = testMethod.getDeclaringClass().getSimpleName();
        int numberOfParameters = testMethod.getParameterTypes().length;
        return getDataFromXls(testClassName, testMethodName, numberOfParameters);
    }

    @DataProvider(name = "xls_provider_factory")
    public static Object[][] getTestDataDefault() {
        return getDataFromXls("FactoryData", "factoryDataProviderTest", 1);
    }
}
