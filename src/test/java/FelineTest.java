import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

public class FelineTest {

    @Test
    public void getMeatReturnCorrectList() throws Exception {
        Feline feline = Mockito.spy(new Feline());
        List<String> expectedListOfMeat = Arrays.asList("Животные", "Птицы", "Рыба");

        // Мокируем метод getFood
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedListOfMeat);

        List<String> actualListOfMeat = feline.eatMeat();

        Mockito.verify(feline).getFood("Хищник");
        Assert.assertEquals("Method getMeat return incorrect value.", expectedListOfMeat, actualListOfMeat);
    }

    @Test
    public void getFamilyReturnsCorrectValue() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        Assert.assertEquals("Method getFamily return incorrect value.", expectedFamily, actualFamily);
    }

    @Test
    public void getKittensReturnsCorrectValue() {
        Feline feline = new Feline();
        int expectedKittens = 1;

        int actualKittens = feline.getKittens();

        Assert.assertEquals("Method getKittens return incorrect value.", expectedKittens, actualKittens);
    }

    @Test
    public void getKittensWithParametersCall() {
        Feline feline = new Feline();
        int expectedKittens = 10;

        int actualKittens = feline.getKittens(10);

        Assert.assertEquals("Method getKittens with parameter return incorrect value.", expectedKittens, actualKittens);
    }
}
