package axa.recruitment.axabookstore.service;

import axa.recruitment.axabookstore.model.Book;
import java.math.BigDecimal;
import java.util.List;


public interface BookService {
    
    Book create(Book b);
    
    Integer update(String isbn, Book b);

    boolean delete(String id);
    
    List<Book> findAll();

    Book findById(String isbn);
    
    List<Book> findByContext(String context, String keyword);
    
    List<Book> findByPrice(BigDecimal min, BigDecimal max);
    
}
