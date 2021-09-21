public class LibrarianAdministrator extends User implements Librarian, Administrator{
	
	public LibrarianAdministrator(String name){
		super(name);
	}

	@Override
	public void findBook(Reader reader){
		System.out.println("Administrator " + getName() + " is looking for a book for the reader " + reader);
	}
	@Override
	public void giveBook(Reader reader){
		System.out.println("Administrator " + getName() + " gives book to the reader " + reader);
	}
	@Override
	public void notifyAboutDelay(Reader reader){
		System.out.println("Administrator " + getName() + " notifies reader " + reader + " about delay");
	}
	@Override
	public void orderBook(Supplier supplier){
		System.out.println("Librarian " + getName() + " orders book from the supplier " + supplier);
	}
}