package libraryBookManager;

public class Book {
private String title;
private String author;
private String isbn;
private int quantity;
private String category;
private String genre;
public Book(String title, String author, String isbn, int quantity,
        String category, String genre) {


this.title = title;

this.author = author;

this.isbn = isbn;

this.quantity = quantity;

this.category = category;

this.genre = genre;

}
 public String getTitle(){
return title;	
}
 public void setTitle(String title) {
	 this.title=title;
 }
public String getAuthor(){
return author;	
}
public void  setAuthor(String author) {
	this.author=author;
}
public String getISBN() {
return isbn;	
}
public void setISBN(String isbn) {
	this.isbn=isbn;
}
public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
    if(quantity >= 0) {
        this.quantity = quantity;
    }
}
public String getCategory(){

    return category;

}


public String getGenre(){

    return genre;

}
public void setCategory(String category){

    this.category = category;

}


public void setGenre(String genre){

    this.genre = genre;

}
@Override
public String toString() {
	return "Book [title=" + title +
		       ", author=" + author +
		       ", isbn=" + isbn +
		       ", quantity=" + quantity +
		       ", category=" + category +
		       ", genre=" + genre + "]";
}
}
