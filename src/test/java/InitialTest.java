import org.testng.Assert;
import org.testng.annotations.Test;

public class InitialTest {

    @Test
    public void testAddition() {
        int a = 5;
        int b = 7;
        int result = a + b;
        Assert.assertEquals(result, 12, "Sum should be equal to 12");
        System.out.println("Test1 is passed");
    }

    @Test
    public void testSubtraction() {
        int a = 10;
        int b = 3;
        int result = a - b;
        Assert.assertEquals(result, 7, "Difference between the numbers must be 7");
        System.out.println("Test2 is passed");
    }
}