import java.util.*;

class Main{
	public static void main(String[] args){
		int SIZE = 10;
		int[][] warField = new int[SIZE][SIZE];

		int EMPTY = 0;
		int SHIP = 1;
		int DEAD = 2;
		int MISS = 3;

		int MAX_COUNT = 10;
		int MAX_STEP = 30;

		int x;
		int y;
		int limit = 0;

		Random random = new Random();
		Scanner in = new Scanner(System.in);
		//заполняем карту кораблями
		for (int i = 0; i < MAX_COUNT; i++) {
  			int shipPlace1 = random.nextInt(SIZE);
  			int shipPlace2 = random.nextInt(SIZE);
  
  			if (warField[shipPlace1][shipPlace2] == SHIP){
    			i--;
  			}

  			warField[shipPlace1][shipPlace2] = SHIP;
		}
		System.out.println("Battleship.\nMap:");
		//вывод карты на экран
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(warField[i][j] + " ");
			}
			System.out.println();
		}

		for(int i = 0; i < MAX_STEP; i++){
			System.out.println("Enter coordinates of the ship. Example: 1:1.\nSteps are left (" + (MAX_STEP - i) + "):");
			String line = in.nextLine();
			String[] masLine = line.split(":");
			x = Integer.parseInt(masLine[0]) - 1;
			y = Integer.parseInt(masLine[1]) - 1;

			if(warField[x][y] == EMPTY){
				warField[x][y] = MISS;
				System.out.println("You've missed.");
			} else if (warField[x][y] == SHIP) {
				warField[x][y] = DEAD;
				limit++;
				System.out.println("You got it!");
			}
			System.out.println("\nMap:");
			for (int k = 0; k < SIZE; k++) {
				for (int j = 0; j < SIZE; j++) {
					System.out.print(warField[k][j] + " ");
				}
				System.out.println();
			}
			if(limit == MAX_COUNT){
				break;
			}
		}
		if(limit == MAX_COUNT){
			System.out.println("You've won! Congratulations!");
		} else {
			System.out.println("You've lost! What a pity...");
		}
	}
}