import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    String bunName = "Super-Bun";
    float bunPrice = 100;
    Bun bun = new Bun(bunName, bunPrice);

    @Test
    public void getNameTest() {
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals(bunPrice, bun.getPrice(), 0);
    }
}
