public class Book{
  Author author;
  String name;
  int pages;
  int year;

  public Book(Author author,String name, int pages, int year){
    this.author = author;
    this.name = name;
    this.pages = pages;
    this.year = year;
  }
  public String toStringBook(){
  	
  	return author.toStringAuthor() + "\nBook: " + name + ", " + pages + " pgs, " + year + " year";
  }
}