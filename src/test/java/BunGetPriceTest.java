import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunGetPriceTest {
    String name;
    float price;

    public BunGetPriceTest(float price) {
        this.name = "Hot Chilly Paper Bun";
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: цена булки \"{0}\"")
    public static Object[][] testData() {
        return new Object[][]{
                {75},
                {146.47f},
                {-75},
                {0},
                {0.1E-44f},
                {-3.4E38f},
                {3.4E38f}
        };
    }

    @Test
    public void bunGetNameTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(), 0);
    }

}
