public class ProbException extends Exception{
    public ProbException(){
        System.out.println("Incorrect data. The factorial of a negative number cannot be considered. n, k numbers and probability (p) also can't be negative. Probability (p) can't be bigger than 1.");
    }
}
