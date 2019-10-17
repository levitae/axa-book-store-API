package axa.recruitment.axabookstore.service;

import axa.recruitment.axabookstore.model.Book;
import axa.recruitment.axabookstore.repository.BookRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repo;

    @Override
    public Book create(Book b) {
        return repo.save(b);
    }

    @Override
    public List<Book> findAll() {
        return repo.findAll();
    }

    @Override
    public Book findById(String isbn) {
        return repo.findBookById(isbn);
    }

    @Override
    public List<Book> findByContext(String context, String keyword) {
        return repo.findByContext(keyword, context);
    }

    @Override
    public List<Book> findByPrice(BigDecimal min, BigDecimal max) {
        return repo.findByPrice(min, max);
    }

    @Override
    public Integer update(String isbn, Book b) {
        return repo.update(isbn, b.getISBN(), b.getBookTitle(), b.getAuthor(), b.getGenre(), b.getPrice(), b.getStock());
    }

    @Override
    public boolean delete(String isbn) {
        Book b = findById(isbn);
        if (b != null) {
            repo.delete(b);
            return true;
        }
        return false;
    }

}
