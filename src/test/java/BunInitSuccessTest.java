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
                {"Hot Chilly Paper Bun", 100},
                {"Русская Сдобная Булка \"По-нашему\"", 146.47f},
                {"", 100},
                {null, 100},
                {"Exorcizo te, immundissime spiritus, omnis incursio adversarii, omne phantasma, omnis legio, in nomine Domini nostri Jesu Christi eradicare, et effugare ab hoc plasmate Dei. Ipse tibi imperat, qui te de supernis caelorum in inferiora terrae demergi praecepit. Ipse tibi imperat, qui mari, ventis, et tempestatibus impersvit. Audi ergo, et time, satana, inimice fidei, hostis generis humani, mortis adductor, vitae raptor, justitiae declinator, malorum radix, fomes vitiorum, seductor hominum, proditor gentium, incitator invidiae, origo avaritiae, causa discordiae, excitator dolorum: quid stas, et resistis, cum scias. Christum Dominum vias tuas perdere? Illum metue, qui in Isaac immolatus est, in joseph venumdatus, in sgno occisus, in homine cruci- fixus, deinde inferni triumphator fuit. Sequentes cruces fiant in fronte obsessi. Recede ergo in nomine Patris et Filii, et Spiritus Sancti: da locum Spiritui Sancto, per hoc signum sanctae Cruci Jesu Christi Domini nostri: Qui cum Patre et eodem Spiritu Sancto vivit et regnat Deus, Per omnia saecula saeculorum. Et cum spiritu tuo. Amen.", 100},
                {"H%t Ch$lly P@per B/n", 100},
                {"bun with which you can earn", -100},
                {"social bun", 0},
                {"almost a social bun", 0.1E-44f},
                {"what you know about float", -3.4E38f},
                {"max bun", 3.4E38f}
        };
    }

    @Test
    public void bunInitSuccessTest() {
        Bun bun = new Bun(name, price);
        Assert.assertNotNull(bun);
    }

}
