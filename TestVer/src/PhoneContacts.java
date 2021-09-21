import java.util.*;

public class PhoneContacts {
    private HashMap<String, List<Contacts>> groups = new HashMap();
    private List<String> keys = new LinkedList<>();


    public void addGroup(String group){
        keys.add(group);
        groups.put(group, new LinkedList<Contacts>());
    }
    public void addContact(Contacts contact, String[] input){
        for(String line: input) {
            if (groups.containsKey(line)) {
                List<Contacts> list = groups.get(line);
                list.add(contact);
                groups.put(line, list);
            }
            else{
                System.out.format("Группы %s не существует\n", line);
            }
        }
    }

    @Override
    public String toString(){
        String result = "";
        for(String line: keys){
            result += "\n" + line + "\n";
            for(int i = 0; i < groups.get(line).size(); i++){
                result += groups.get(line).get(i) + "\n";
            }
        }
        return result;
    }
}
