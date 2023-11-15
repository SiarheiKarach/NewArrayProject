import com.karach.arrayproject.exception.ArrayException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.karach.arrayproject.service.impl.ArrayModelServiceImpl;
import static org.testng.Assert.assertEquals;

public class ArrayModelServiceImplTest {

  @DataProvider(name = "arrayProvider")
  public Object[][] arrayProvider() {
    return new Object[][]{
            {new int[]{3, 1, 4, 2, 5}, 1},
            {new int[]{3, 1, 4, 2, 5}, 6},
            {new int[]{3, 1, 4, 2, 5, 3, 3}, 3},
            {new int[]{3, 1, 4, 2, 5}, 3},
            {new int[]{3, 1, 4, 2, 5}, 15},
            {new int[]{-3, 1, 4, -2, 5, -3, 3}, 4},
            {new int[]{-3, 1, 4, -2, 5, -3, 3}, 3}
    };
  }

  @Test(dataProvider = "arrayProvider")
  public void testArrayOperations(int[] array, int expected) throws ArrayException {
    ArrayModelServiceImpl arrayModelService = new ArrayModelServiceImpl();

    if (expected == 1) {
      int min = arrayModelService.findMin(array);
      assertEquals(min, expected);
    } else if (expected == 6) {
      int max = arrayModelService.findMax(array);
      Assert.assertNotEquals(max, expected);
    } else if (expected == 3) {
      int replacedCount = arrayModelService.replaceElementsNumber(array, 3, 6);
      assertEquals(replacedCount, expected);
      double average = arrayModelService.findAverage(array);
      assertEquals(average, expected);
      int positiveElements = arrayModelService.countPositiveElements(array);
      assertEquals(positiveElements, expected);
      int negativeElements = arrayModelService.countNegativeElements(array);
      assertEquals(negativeElements, expected);
    } else if (expected == 15) {
      double sum = arrayModelService.findSum(array);
      assertEquals(sum, expected);
    }
  }
}