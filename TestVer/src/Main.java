public class Main {
    public static void main(String[] args) {
        PhoneContacts phoneContacts = new PhoneContacts();
        Contacts cont1 = new Contacts("Вася", "12");
        Contacts cont2 = new Contacts("Оля", "14");
        Contacts cont3 = new Contacts("Петя", "13");
        Contacts cont4 = new Contacts("Коля", "7");
        Contacts cont5 = new Contacts("Олеся", "20");

        phoneContacts.addGroup("Семья");
        phoneContacts.addGroup("Друзья");
        phoneContacts.addGroup("Одноклассники");

        String[] list1 = {"Семья", "Друзья", "Одноклассники"};
        String[] list2 = {"Друзья", "Люди"};
        String[] list3 = {"Друзья"};

        phoneContacts.addContact(cont1, list1);
        phoneContacts.addContact(cont2, list1);
        phoneContacts.addContact(cont3, list2);
        phoneContacts.addContact(cont4, list2);
        phoneContacts.addContact(cont5, list3);

        System.out.println(phoneContacts);
    }
}
