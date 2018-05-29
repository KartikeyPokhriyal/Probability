import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProbabilityTest {
    final double PROBABILITY_OF_TAIL = 0.5;

    @Test
    public void validateChanceOfGettingATail() {
        Probability probability = new Probability(PROBABILITY_OF_TAIL);

        assertEquals(probability, new Probability(0.5));
    }

    @Test
    public void validateChanceOfNotGettingATail() {
        Probability probability = new Probability(PROBABILITY_OF_TAIL);

        assertEquals(probability.not(), new Probability(0.5));
    }

    @Test
    public void validateChanceOfGettingTwoTails() {
        Probability probabilityOfFirstCoin = new Probability(PROBABILITY_OF_TAIL);
        Probability probabilityOfSecondCoin = new Probability(PROBABILITY_OF_TAIL);

        assertEquals(probabilityOfFirstCoin.and(probabilityOfSecondCoin), new Probability(0.25));
    }

    @Test
    public void validateChanceOfGettingAtLeastOneTail() {
        Probability probabilityOfFirstCoin = new Probability(PROBABILITY_OF_TAIL);
        Probability probabilityOfSecondCoin = new Probability(PROBABILITY_OF_TAIL);

        assertEquals(probabilityOfFirstCoin.or(probabilityOfSecondCoin), new Probability(0.75));
    }

    @Test
    public void returnProbabilityOfGettingExactlyTwoBlueBalls() {
        ProbabilityOfBalls probabilityOfBalls = new ProbabilityOfBalls(5,1,2,2);

        assertEquals(probabilityOfBalls.exactly(0,2,0), new ProbabilityOfBalls(0.1));
    }

    @Test
    public void returnProbabilityOfGettingExactlyOneRedAndOneBlueBall() {
        ProbabilityOfBalls probabilityOfBalls = new ProbabilityOfBalls(5,1,2,2);

        assertEquals(probabilityOfBalls.exactly(1,1,0), new ProbabilityOfBalls(0.2));
    }

    @Test
    public void returnProbabilityOfGettingThreeDistinctBalls() {
        ProbabilityOfBalls probabilityOfBalls = new ProbabilityOfBalls(5,1,2,2);

        assertEquals(probabilityOfBalls.exactly(1,1,1), new ProbabilityOfBalls(0.4));
    }

}
