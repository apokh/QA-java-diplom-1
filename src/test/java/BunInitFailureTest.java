import org.junit.Test;
import praktikum.Bun;

public class BunInitFailureTest {
    @Test(expected=NullPointerException.class)
    public void bunInitFailureTest(){
            Float price = null;
            Bun bun = new Bun("null-bun", price);
    }
}
