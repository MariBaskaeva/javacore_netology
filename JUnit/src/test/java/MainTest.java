import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {
    private static long startTime;
    private long testStartTime;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Running tests");
        startTime = System.nanoTime();
    }
    @BeforeEach
    public void beforeEach(){
        System.out.println("New test started");
        testStartTime = System.nanoTime();
    }
    @Test
    public void testProbCoinsSuccess() throws ProbException {
        // given:
        final Integer n = 1;
        final Integer k = 1;
        final Double expected = 0.5;

        // when:
        final Double result;
            result = (new ProbCoins(n, k)).probability();

        // then:
        assertEquals(result, expected);
    }

    @Test
    public void testProbCoinsFailure(){
        // given:
        final Integer n = -1;
        final Integer k = 2;

        // then:
        assertThrows(ProbException.class, () -> {
            final Double result = (new ProbCoins(n, k)).probability();
        });
    }

    @Test
    public void testBernulliSuccess() throws ProbException {
        // given:
        final Integer n = 1;
        final Integer k = 1;
        final Double p = 0.5;
        final Double expected = 0.5;

        // when:
        final Double result = (new Bernulli(n, k, p)).probability();

        // then:
        assertEquals(result, expected);
    }

    @Test
    public void testBernulliFailure(){
        // given:
        final Integer n = 2;
        final Integer k = 1;
        final Double p = 2.4;

        // then:
        assertThrows(ProbException.class, () -> {
            (new Bernulli(n, k, p)).probability();
        });
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 0.5", "2, 1, 0.5", "2, 2, 0.25", "4, 3, 0.25"})
    void testParameterizedProbCoinsSuccess(Integer n, Integer k, Double expected) throws ProbException{
        final Double result = (new ProbCoins(n, k)).probability();

        assertEquals(expected, result);
    }

    @AfterEach
    public void afterEach(){
        System.out.println("Test complete: " + (System.nanoTime() - testStartTime) + " ns");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("All tests were completed: " + (System.nanoTime() - startTime) / 1000000 + " ms");
    }
}
