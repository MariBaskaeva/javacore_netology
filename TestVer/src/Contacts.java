import java.util.*;

public class Contacts {
    private String name;
    private String number;

    public Contacts(String name, String number){
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object obj){
        Contacts contact = (Contacts) obj;
        return this.toString().equals(contact.toString());
    }
    @Override
    public String toString(){
        return "Имя: " + name + "\tТел.: " + number;
    }

}
