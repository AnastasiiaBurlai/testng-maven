package ddt;

import org.testng.Reporter;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactoryTests {

    private String param;

    public FactoryTests(String param) {
        this.param = param;
    }

    @Factory
    public Object[] factoryMethod() {
        return new Object[]{new FactoryTests("factoryParam0_"), new FactoryTests("factoryParam1_")};
    }

    @Test
    public void testWithFactory1() {
        Reporter.log(String.format("Test1 with factory: %s 1", param), true);
    }

    @Test
    public void testWithFactory2() {
        Reporter.log(String.format("Test2 with factory: %s 2", param), true);
    }
}