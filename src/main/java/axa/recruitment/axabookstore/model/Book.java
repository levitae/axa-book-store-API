package axa.recruitment.axabookstore.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book implements Serializable {

    @Id
    private String _ISBN;

    @Column(name = "BOOK_TITLE")
    private String bookTitle;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "STOCK")
    private Integer stock;

    public String getISBN() {
        return _ISBN;
    }

    public void setISBN(String _ISBN) {
        this._ISBN = _ISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" + "_ISBN=" + _ISBN + ", bookTitle=" + bookTitle + ", author=" + author + ", genre=" + genre + ", price=" + price + ", stock=" + stock + '}';
    }

}
