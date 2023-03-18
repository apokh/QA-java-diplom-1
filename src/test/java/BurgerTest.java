import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger = new Burger();

    @Test
    public void setBunTest() {
        String bunName = "Any Bun Name";
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Assert.assertEquals(bunName, burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        String ingredientName = "Кетченез";
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, ingredientName, 19.99f);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredientName, burger.ingredients.get(0).name);
    }

    //    ингредиентов больше одного - чтобы проверить суммирование, а больше двух - чтобы не повторять х2 (как у булок)
    @Test
    public void getPriceTest() {
        float bunPrice = 9.99f;
        float ingredientPrice = 75.00f;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Assert.assertEquals(bunPrice * 2 + ingredientPrice * 3, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        String bunName = "BurgerBun";
        IngredientType ingredientType = IngredientType.FILLING;
        String ingredientTypeString = ingredientType.toString().toLowerCase();
        String ingredientName = "AlmostSteak";
        float bunPrice = 9.99f;
        float ingredientPrice = 75.00f;
        float burgerPrice = bunPrice * 2 + ingredientPrice;
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        String expectedReceipt = String.format("(==== " + bunName + " ====)%n= " + ingredientTypeString + " " + ingredientName + " =%n(==== " + bunName + " ====)%n%nPrice: %f%n", burgerPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
