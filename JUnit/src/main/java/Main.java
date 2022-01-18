import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Choose an exercise:\n" +
                "1. An exercise with coins\n" +
                "2. An exercise using Bernulli method");

        switch(in.nextInt()){
            case 1:
                System.out.println("Please, input n and k, using enter button");
                ProbCoins probCoins = null;
                try {
                    probCoins = new ProbCoins(in.nextInt(), in.nextInt());
                    System.out.println("The result is: " + probCoins.probability());
                } catch (ProbException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("Please, input n, k and p, using enter button");
                Bernulli bernulli = null;
                try {
                    bernulli = new Bernulli(in.nextInt(), in.nextInt(), in.nextDouble());
                    System.out.println("The result is: " + bernulli.probability());
                } catch (ProbException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("There's no such exercise");
        }
    }
}