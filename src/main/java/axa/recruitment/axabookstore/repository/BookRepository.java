package axa.recruitment.axabookstore.repository;

import axa.recruitment.axabookstore.model.Book;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<Book, String>, JpaSpecificationExecutor {
 
    @Transactional
    @Modifying
    @Query(value = "UPDATE Book b set b._ISBN = :isbn, b.bookTitle = :title, b.author = :author, b.genre = :genre, b.price = :price, b.stock = :stock WHERE b._ISBN = :original_isbn")
    Integer update(
            @Param("original_isbn") String originalISBN,
            @Param("isbn") String isbn,
            @Param("title") String title,
            @Param("author") String author,
            @Param("genre") String genre,
            @Param("price") BigDecimal price,
            @Param("stock") Integer stock);

    @Query(value = "SELECT b FROM Book b where b._ISBN =:isbn")
    Book findBookById(@Param("isbn") String isbn);
    
}
