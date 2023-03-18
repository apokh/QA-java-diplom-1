import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunInitSuccessTest {
    String name;
    float price;

    public BunInitSuccessTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: булка \"{0}\" за {1} рублей")
    public static Object[][] testData() {
        return new Object[][]{
                {"Hot Chilly Paper Bun", 100500},
                {"Русская Сдобная Булка \"По-нашему\"", 146.47f}
        };
    }

    @Test
    public void bunInitSuccessTest() {
        Bun bun = new Bun(name, price);
        Assert.assertNotNull(bun);
    }

}
