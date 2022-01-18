import static java.lang.Math.pow;

public class ProbCoins extends Probability {
    ProbCoins(Integer n, Integer k) throws ProbException {
        super(n, k);
    }

    @Override
    public Double probability(){
        return numOfComb() / pow(2, super.n);
    }
}
