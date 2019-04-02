import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import parser.JsonParser;
import shop.Cart;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class TestForJsonParserClassWriteTo {
    JsonParser parser = null;
    Cart lenaCart = null;

    @BeforeTest(alwaysRun = true)
    public void createJsonParser() {
        parser = new JsonParser();
        lenaCart = new Cart("lena-cart");
    }

    @Test(groups = {"functional", "regression"})
    public void scenarioWriteToValidData() {
        parser.writeToFile(lenaCart);
        File folder = new File("src/main/resources/");
        File[] arrayOfFilesInResourcesFolder = folder.listFiles();
        ArrayList<File> arrayListOfFilesInResourcesFolder = new ArrayList<File>(Arrays.asList(arrayOfFilesInResourcesFolder));
        boolean isFileEqualToCartName = false;
        if (arrayListOfFilesInResourcesFolder != null) {
            isFileEqualToCartName = arrayListOfFilesInResourcesFolder.stream()
                    .anyMatch(file -> file.getName().equals("lena-cart.json"));
        }
        Assert.assertTrue(isFileEqualToCartName, "\"File name is equal to Cart name\"");
    }

    @AfterTest(alwaysRun = true)
    public void removeAllFilesCreatedInTests() {
        File folder = new File("src/main/resources/");
        File[] arrayListOfFiles = folder.listFiles();
        if (arrayListOfFiles != null) {
            Stream.of(arrayListOfFiles)
                    .filter(file -> !file.getName().contains("andrew-cart.json") && !file.getName().contains("eugen-cart.json"))
                    .forEach(f -> new File(f.getAbsolutePath()).delete());
        }
    }
}