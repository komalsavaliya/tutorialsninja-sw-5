package resource.testdata;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "Product1")
    public Object[][] getProduct1() {
        Object[][] data = new Object[][]{
                {"HTC Touch HD", "1", "Success: You have added HTC Touch HD to your shopping cart!", "HTC Touch HD", "Product 1", "£74.73"}

        };

        return data;
    }

    @DataProvider(name = "Product2")
    public Object[][] getProduct2() {
        Object[][] data = new Object[][]{

        };
        return data;
    }

    @DataProvider(name = "Product3")
    public Object[][] getProduct3() {
        Object[][] data = new Object[][]{
                {"Palm Treo Pro", "3", "Success: You have added Palm Treo Pro to your shopping cart!", "Palm Treo Pro", "Product 2", "£1,242.11"}
        };
        return data;
    }
}
