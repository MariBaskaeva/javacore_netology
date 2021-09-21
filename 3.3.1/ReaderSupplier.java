public class ReaderSupplier extends User implements Reader, Supplier{

	public ReaderSupplier(String name){
		super(name);
	}

	@Override
	public void bringBook(Librarian librarian){
		System.out.println("Supplier " + getName() + " brings book to the librarian " + librarian);
	}
	@Override
	public void getBook(Administrator administrator){
		System.out.println("Reader " + getName() + " gets book from administrator " + administrator);
	}
	@Override
	public void returnBook(Administrator administrator){
		System.out.println("Reader " + getName() + " returns book to administrator " + administrator);
	}
}