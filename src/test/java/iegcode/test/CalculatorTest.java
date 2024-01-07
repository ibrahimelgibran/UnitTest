package iegcode.test;

import iegcode.test.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void BeforeAll(){
        System.out.println("Before All");
    }

    @AfterAll
    public static void AfterAll(){
        System.out.println("After All");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("After Each");
    }

    @Test
    public void testAddSuccess() {
        int result = calculator.add(10, 10);
        assertEquals(20, result, "Addition failed");
    }

    @Test
    public void testDivideSuccess() {
        int result = calculator.divide(100, 10);
        assertEquals(10, result, "Division failed");
    }

    @Test
    public void testDivideFailed() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        }, "Expected IllegalArgumentException for division by zero");
    }

    @Test
    @Disabled
    public void testComingSoon(){

    }

    //membatalkan
    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)){
            throw new TestAbortedException("Test dibatakan karena bukan DEV");
        }
        // Unit test untuk dev
    }

    @Test
    public void testAssumptions(){
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
        // Unit test untuk dev
    }
}
