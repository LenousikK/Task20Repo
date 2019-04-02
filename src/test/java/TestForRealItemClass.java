import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;

public class TestForRealItemClass {
    Cart lenaCart = null;
    RealItem dog = null;

    @BeforeTest (alwaysRun = true)
    public void createNewCartAndItems() {
        lenaCart = new Cart("lena-cart");
        dog = new RealItem();
    }

    @Test(groups = "functional")
    void scenarioForToString() {
        dog.setName("Max");
        dog.setPrice(850);
        dog.setWeight(8);
        lenaCart.addRealItem(dog);
        Assert.assertEquals("Class: class shop.RealItem; Name: Max; Price: 850.0; Weight: 8.0", dog.toString());
    }
}