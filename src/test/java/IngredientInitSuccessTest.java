import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientInitSuccessTest {
    IngredientType type;
    String name;
    float price;

    public IngredientInitSuccessTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} \"{1}\" за {2} рублей")
    public static Object[][] testData() {
        return new Object[][]{
                {IngredientType.FILLING, "Steak", 99.9f},
                {IngredientType.SAUCE, "Gor'kiy", 0.01f}
        };
    }

    @Test
    public void ingredientInitSuccessTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertNotNull(ingredient);
    }
}
