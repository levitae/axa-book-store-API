package axa.recruitment.axabookstore.repository;

import axa.recruitment.axabookstore.model.Book;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends JpaRepository<Book, String> {

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

//    @Transactional
//    @Modifying
//    @Query(value = "DELETE FROM Book b WHERE b._ISBN = :isbn")
//    Boolean deleteBook(@Param("isbn") String isbn);

    @Query(value = "SELECT b FROM Book b where b._ISBN =:isbn")
    Book findBookById(@Param("isbn") String isbn);

    @Query(value = "SELECT b FROM Book b where b.price >= :min and b.price <= :max")
    List<Book> findByPrice(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query(value = "SELECT b FROM Book b where :key = :value")
    List<Book> findByContext(@Param("key") String key, @Param("value") String value);

//    @Query("SELECT u.username FROM User u WHERE u.username LIKE CONCAT('%',:username,'%')")
//    List<String> findUsersWithPartOfName(@Param("username") String username);
}
