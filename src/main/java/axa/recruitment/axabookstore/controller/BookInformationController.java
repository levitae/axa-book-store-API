package axa.recruitment.axabookstore.controller;

import axa.recruitment.axabookstore.service.BookService;
import axa.recruitment.axabookstore.util.Response;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book/info")
public class BookInformationController {

    @Autowired
    private BookService service;

    @GetMapping("/by-title/{keyword}")
    public ResponseEntity<Response> findByTitle(@PathVariable(name = "keyword") String keyword) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("List of books titled: " + keyword);
        response.setData(service.findByContext("bookTitle", keyword));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/by-author/{keyword}")
    public ResponseEntity<Response> findByAuthor(@PathVariable(name = "keyword") String keyword) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("List of books by author: " + keyword);
        response.setData(service.findByContext("author", keyword));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
    
    @GetMapping("/by-genre/{keyword}")
    public ResponseEntity<Response> findByGenre(@PathVariable(name = "keyword") String keyword) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("List of books by genre: " + keyword);
        response.setData(service.findByContext("genre", keyword));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @GetMapping("/by-price-range/{min}/{max}")
    public ResponseEntity<Response> findByPriceRange(
            @PathVariable(name = "min") BigDecimal min,
            @PathVariable(name = "max") BigDecimal max
    ) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("List of books priced between: " + min + " - " + max);
        response.setData(service.findByPrice("price", min, max));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

}
