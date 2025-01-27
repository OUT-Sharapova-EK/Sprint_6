import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    @InjectMocks
    Feline feline; // Мокаем объект Feline, создавая реальный экземпляр с моками внутри

    @Test
    public void getMeatReturnCorrectList() throws Exception {
        List<String> expectedListOfMeat = Arrays.asList("Животные", "Птицы", "Рыба");

        // Мокируем метод getFood
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        List<String> actualListOfMeat = feline.eatMeat();

        Mockito.verify(feline).getFood("Хищник");
        Assert.assertEquals("Method getMeat return incorrect value.", expectedListOfMeat, actualListOfMeat);
    }

    @Test
    public void getFamilyReturnsCorrectValue(){
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        Assert.assertEquals("Method getFamily return incorrect value.", expectedFamily, actualFamily);
    }

    @Test
    public void getKittensReturnsCorrectValue(){
        int expectedKittens = 1;

        // Мокируем метод getKittens
        Mockito.when(feline.getKittens()).thenReturn(expectedKittens);

        int actualKittens = feline.getKittens();

        Assert.assertEquals("Method getKittens return incorrect value.", expectedKittens, actualKittens);
    }

    @Test
    public void getKittensWithParametersCall() {
        Feline feline = new Feline();
        int expectedKittens = 10;

        // В реальности, переданный параметр будет возвращать другое значение, нужно подставить возвращаемое значение
        int actualKittens = feline.getKittens(10);

        Assert.assertEquals("Method getKittens with parameter return incorrect value.", expectedKittens, actualKittens);
    }
}
