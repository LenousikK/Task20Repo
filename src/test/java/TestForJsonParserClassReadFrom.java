import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import parser.JsonParser;
import parser.NoSuchFileException;

public class TestForJsonParserClassReadFrom {
    JsonParser parser = null;

    @BeforeTest(alwaysRun = true)
    public void createJsonParser() {
        parser = new JsonParser();
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"abc1"}, {"abc2"}, {"abc3"}, {"abc4"}, {"abc5"}};
    }

    @Test(dataProvider = "data-provider", groups = {"functional", "regression"}, expectedExceptions = parser.NoSuchFileException.class)
    public void scenarioReadFromInvalidData(String resourcesFolderPath) {
        File fileToRead = new File("src/main/resources/" + resourcesFolderPath);
        parser.readFromFile(fileToRead);
    }
}