import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Ожидаю ввода этажа (введите 0, чтобы выйти): ");
            int floor = in.nextInt();
            if (floor == 0)
                break;
            else if (floor < 0 || floor > 25) {
                System.out.println("Такого этажа нет в доме.");
                continue;
            }
            queue.offer(floor);
        }

        System.out.println("Лифт проследовал по следующим этажам: ");
        int waitDoorsInSeconds = 10;
        int waitMoveInSeconds = 5;
        int totalSeconds = 0;
        int previousFloor = -1;

        while (!queue.isEmpty()) {
            int currentFloor = queue.poll();
            if (previousFloor != -1) {
                totalSeconds += Math.abs(currentFloor - previousFloor) * waitMoveInSeconds;
            }
            totalSeconds += waitDoorsInSeconds;
            System.out.print("этаж " + currentFloor);
            previousFloor = currentFloor;
            if (!(queue.peek() == null))
                System.out.print(" -> ");
            else
                break;
        }
        System.out.print("\nВремя затраченное лифтом на маршрут =: " + totalSeconds + " с.");
    }
}
