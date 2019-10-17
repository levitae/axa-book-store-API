package axa.recruitment.axabookstore.service;

import axa.recruitment.axabookstore.model.Book;
import axa.recruitment.axabookstore.repository.BookRepository;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
    public List<Book> findByContext(String columnName, String keyword) {
        return repo.findAll(stringByColumnNameAndValue(columnName, keyword));
    }

    @Override
    public List<Book> findByPrice(String columnName, BigDecimal min, BigDecimal max) {
        return repo.findAll(priceByColumnNameAndValue(columnName, min, max));
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

    public static Specification<Book> stringByColumnNameAndValue(String columnName, String value) {
        return new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root,
                    CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.like(builder.lower(root.<String>get(columnName)), "%" + value.toLowerCase() + "%");
            }
        };
    }
    
    public static Specification<Book> priceByColumnNameAndValue(String columnName, BigDecimal min, BigDecimal max) {
        return new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root,
                    CriteriaQuery<?> query, CriteriaBuilder builder) {
                return builder.between(root.<BigDecimal>get(columnName), min, max);
            }
        };
    }

}
