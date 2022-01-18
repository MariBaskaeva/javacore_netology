public abstract class Probability{
    Integer n = null, k = null;

    Probability(Integer n, Integer k) throws ProbException{
        if(n < 0 || k < 0 || (n - k) < 0)
            throw new ProbException();
        this.n = n;
        this.k = k;
    }

    public Integer numOfComb(){
        return Factorial.factorial(n)
                / Factorial.factorial(k) * Factorial.factorial(n - k);
    }

    public Double probability(){
        return 0.0;
    }
}
