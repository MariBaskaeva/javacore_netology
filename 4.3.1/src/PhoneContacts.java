import java.util.*;

public class PhoneContacts {
    private HashMap<String, List<Contact>> groups = new HashMap<>();

    public void addGroup(String name){
        groups.put(name, null);
    }

    public void addContact(Contact contact){
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите группы контакта через пробел");
        String[] input = in.nextLine().split(" ");
        for(String line: input){
            if(groups.containsKey(line)){
                //groups.put(line, contact);
        }
    }
}
