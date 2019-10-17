package axa.recruitment.axabookstore.controller;

import axa.recruitment.axabookstore.model.Book;
import axa.recruitment.axabookstore.service.BookService;
import axa.recruitment.axabookstore.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book/manage")
public class BookManagementController {

    @Autowired
    private BookService service;

    public void setEmployeeService(BookService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Response> newBookEntry(Book book) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("New book entry is saved");
        response.setData(service.create(book));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    @PutMapping("/update/{isbn}")
    public ResponseEntity<Response> updateBookInfo(
            @RequestBody Book book,
            @PathVariable(name = "isbn") String isbn
    ) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        String message = "Update Failed";
        if (service.update(isbn, book) == 1) {
            message = "Book " + isbn + " is updated";
        }
        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage(message);
        response.setData(book);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
    
    @DeleteMapping("/delete/{isbn}")
    public ResponseEntity<Response> deleteBook(@PathVariable(name = "isbn") String isbn) {
        String message = "The book to be deleted is not found";
        if (service.delete(isbn)) {
            message = "Book " + isbn + " is updated";
        }
        
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        
        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage(message);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

}