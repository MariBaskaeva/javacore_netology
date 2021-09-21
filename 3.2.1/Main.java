import java.util.*;

class Main{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        System.out.format("У игрока %d слотов с оружием,"
            + " введите номер, чтобы выстрелить,"
            + " -1 чтобы выйти%n", 
            player.getSlotsCount()
        );
        int slot;
        
        while(true){
        	slot = scanner.nextInt();

        	if(slot == -1)
        		break;

        	player.shotWithWeapon(slot);
        }
        
        System.out.println("Game over!");
    }
}