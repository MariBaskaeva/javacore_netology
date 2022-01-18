import static java.lang.Math.pow;

public class Bernulli extends Probability {
    private Double p = null;

    public Bernulli(Integer n, Integer k, Double p) throws ProbException{
        super(n, k);
        if(p < 0 || p > 1)
            throw new ProbException();
        this.p = p;
    }

    @Override
    public Double probability() {
        return numOfComb() * pow(p, k) * pow(1 - p, n - k);
    }
}
