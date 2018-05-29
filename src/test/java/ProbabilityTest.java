import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProbabilityTest {
    final double PROBABILITY_OF_TAIL = 0.5;
    final double PROBABILITY_OF_NOT_TAIL = 0.5;

    @Test
    public void validateChanceOfGettingATail() {
        Probability probability = new Probability(PROBABILITY_OF_TAIL);

        assertEquals(probability, new Probability(0.5));
    }

    @Test
    public void validateChanceOfNotGettingATail() {
        Probability probability = new Probability(PROBABILITY_OF_NOT_TAIL);

        assertEquals(probability, new Probability(0.5));
    }
}
