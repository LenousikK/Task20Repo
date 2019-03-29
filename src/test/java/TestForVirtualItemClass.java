import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import shop.Cart;
import shop.VirtualItem;

@Test(enabled = false)
public class TestForVirtualItemClass {
    Cart lenaCart = null;
    VirtualItem game = null;

    @BeforeTest
    public void createNewCartAndItems() {
        lenaCart = new Cart("lena-cart");
        game = new VirtualItem();
    }

    @Test(groups = "functional")
    void scenarioForToString() {
        game.setName("Game Of Thrones");
        game.setPrice(1.5);
        game.setSizeOnDisk(2500);
        Assert.assertEquals("Class: class shop.VirtualItem; Name: Game Of Thrones; Price: 1.5; Size on disk: 2500.0", game.toString());
    }
}