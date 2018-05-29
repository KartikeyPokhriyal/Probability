import java.util.Objects;

public class ProbabilityOfBalls {

    private int numberOfBalls;
    private int numberOfRedBalls;
    private int numberOfBlueBalls;
    private int numberOfYellowBalls;
    private double probability;

    public ProbabilityOfBalls(int numberOfBalls, int numberOfRedBalls, int numberOfBlueBalls, int numberOfYellowBalls) {
        this.numberOfBalls = numberOfBalls;
        this.numberOfRedBalls = numberOfRedBalls;
        this.numberOfBlueBalls = numberOfBlueBalls;
        this.numberOfYellowBalls = numberOfYellowBalls;
    }

    public ProbabilityOfBalls(double probability) {
        this.probability = probability;
    }

    public int fact(int balls) {
        int iterator;
        int initial = 1;

        for (iterator = 1; iterator <= balls; iterator++) {
            initial = initial * iterator;
        }
        return initial;
    }

    public double ncr(int balls, int number) {
        return fact(balls) / (fact(balls - number) * fact(number));
    }

    public ProbabilityOfBalls exactly(int redBall, int blueBall, int yellowBall) {
        int totalBalls = redBall + blueBall + yellowBall;
        return new ProbabilityOfBalls((ncr(numberOfRedBalls, redBall) * ncr(numberOfBlueBalls, blueBall) * ncr(numberOfYellowBalls, yellowBall)) / ncr(numberOfBalls, totalBalls));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProbabilityOfBalls)) return false;
        ProbabilityOfBalls that = (ProbabilityOfBalls) o;
        return Double.compare(that.probability, probability) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(probability);
    }
}
