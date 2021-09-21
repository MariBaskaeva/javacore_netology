import java.util.*;

public class Main{
	    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        	Scanner scanner = new Scanner(System.in);

       	 	System.out.println("Enter login: ");
        	String login = scanner.nextLine();
        	System.out.println("Enter password: ");
        	String password = scanner.nextLine();

        	User user = getUserByLoginAndPassword(login, password);
        	validateUser(user);
        	
        	System.out.println("Access allowed");
    }

	public static User[] getUsers() {
    	User user1 = new User("jhon", "jhon@gmail.com", "pass", 24);
    	User user2 = new User("Kaneki", "ghoul@gmail.com", "1000-7", 15);
    	return new User[]{user1, user2};
	}

	public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
    	User[] users = getUsers();
    	for (User user : users) {
    	    if(user.getLogin().equals(login) && user.getPassword().equals(password))
    	    	return user;
    	}
    	throw new UserNotFoundException("User not found");    
	}   

	public static void validateUser(User user) throws AccessDeniedException{
		if(user.getAge() < 18)
			throw new AccessDeniedException("Access denied");
	}
}