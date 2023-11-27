public class Stock {
    //attributes
    String bookName;
    String author;
    double price;

    public Stock(String bookName, String author, double price) {
       //complete the constructor
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }
    //complete the getters()
    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}
