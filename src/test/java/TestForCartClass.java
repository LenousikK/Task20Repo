import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

public class TestForCartClass {
    Cart lenaCart = null;
    RealItem dress = null;
    VirtualItem game = null;

    @BeforeTest
    public void createNewCartAndItems() {
        lenaCart = new Cart("lena-cart");
        dress = new RealItem();
        game = new VirtualItem();
    }

    @Test(groups = "uat")
    void scenarioGetTotalPriceForAllItemsInCart() {
        dress.setPrice(50.5);
        lenaCart.addRealItem(dress);
        game.setPrice(1.5);
        lenaCart.addVirtualItem(game);
        Assert.assertEquals(62.4, lenaCart.getTotalPrice());
    }
}