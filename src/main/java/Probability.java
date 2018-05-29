import java.util.Objects;

public class Probability {

    double probability;

    public Probability(double probability) {
        this.probability = probability;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Probability)) return false;
        Probability that = (Probability) o;
        return Double.compare(that.probability, probability) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(probability);
    }

    public Probability not() {
        return  new Probability(1 - probability);
    }

    public Probability and(Probability probabilityOfSecondCoin) {
        return new Probability(probabilityOfSecondCoin.probability * this.probability);
    }

    public Probability or(Probability probabilityOfSecondCoin) {

        return not().and(probabilityOfSecondCoin.not()).not();
    }


}
