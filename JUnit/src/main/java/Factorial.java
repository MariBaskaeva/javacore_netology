public class Factorial {
    public static Integer factorial(Integer f) {
        Integer result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        //System.out.println("***\nfactorial from " + f + "\n***\n" + result);
        return result;
    }
}
