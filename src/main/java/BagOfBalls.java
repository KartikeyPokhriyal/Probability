import java.util.Objects;

public class BagOfBalls {

    private int numberOfBalls;
    private int numberOfRedBalls;
    private int numberOfBlueBalls;
    private int numberOfYellowBalls;

    public BagOfBalls(int numberOfBalls, int numberOfRedBalls, int numberOfBlueBalls, int numberOfYellowBalls) {
        this.numberOfBalls = numberOfBalls;
        this.numberOfRedBalls = numberOfRedBalls;
        this.numberOfBlueBalls = numberOfBlueBalls;
        this.numberOfYellowBalls = numberOfYellowBalls;
    }

    public int factorial(int balls) {
        int iterator;
        int factorial_value = 1;

        for (iterator = 1; iterator <= balls; iterator++) {
            factorial_value = factorial_value * iterator;
        }
        return factorial_value;
    }


    public double ncr(int totalItems, int selectedItems) {
        return factorial(totalItems) / (factorial(totalItems - selectedItems) * factorial(selectedItems));
    }


    public Probability exactly(int redBallDrawn, int blueBallDrawn, int yellowBallDrawn) {
        int totalBalls = redBallDrawn + blueBallDrawn + yellowBallDrawn;
        return new Probability((ncr(numberOfRedBalls, redBallDrawn) * ncr(numberOfBlueBalls, blueBallDrawn) * ncr(numberOfYellowBalls, yellowBallDrawn)) / ncr(numberOfBalls, totalBalls));
    }
}
