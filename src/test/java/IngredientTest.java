import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    String any = "any";
    float sale = 99.99f;
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, any, sale);

    @Test
    public void getIngredientTypeTest() {
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }

    @Test
    public void getIngredientNameTest() {
        Assert.assertEquals(any, ingredient.getName());
    }

    @Test
    public void getIngredientPriceTest() {
        Assert.assertEquals(sale, ingredient.getPrice(), 0);
    }
}
