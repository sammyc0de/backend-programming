package syksy26.bookstore.web;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import syksy26.bookstore.domain.Book;
import syksy26.bookstore.domain.BookRepository;

@RestController 
public class BookRestController {

    private final BookRepository bookRepository;

     public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
       
    }

	@GetMapping("/books")
    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }
    
    @GetMapping("/books/{id}")
    public Optional<Book> findById(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }


}
