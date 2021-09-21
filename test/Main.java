public class Main{
	public static void main(String[] args){
		User user = new User("rozhok@list.ru", "Ilya", "Rozhkov");
		Author author = new Author("Victor", "Hugo", 1802, "France");
		Book book1 = new Book(author, "The Man Who Laughs", 540, 1869);
		Book book2 = new Book(author, "Les Miserables", 1560, 1862);
		Book book3 = new Book(author, "Notre-Dame de Paris", 458, 1831);

		user.addBook(book1);
		user.addBook(book2);
		user.addBook(book3);

		System.out.println(user.toString());
	}
}