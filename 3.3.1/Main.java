public class Main{
	public static void main(String[] args){
		ReaderSupplier readerSupplier = new ReaderSupplier("Levi Akkerman");
		LibrarianAdministrator librarianAdministrator = new LibrarianAdministrator("Eren Ieger");

		librarianAdministrator.orderBook(readerSupplier);
		readerSupplier.bringBook(librarianAdministrator);
		librarianAdministrator.findBook(readerSupplier);
		librarianAdministrator.giveBook(readerSupplier);
		readerSupplier.getBook(librarianAdministrator);
		librarianAdministrator.notifyAboutDelay(readerSupplier);
		readerSupplier.returnBook(librarianAdministrator);
	}
}