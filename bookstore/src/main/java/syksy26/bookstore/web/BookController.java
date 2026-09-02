package syksy26.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import syksy26.bookstore.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import syksy26.bookstore.domain.BookRepository;

@Controller
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    public static final List<Book> books = new ArrayList<>();

  
    @GetMapping("/index")
    public String showBooks(Model model) {
        model.addAttribute("books", repository.findAll());
        return "bookList";
    }

    @PostMapping("/save")
    public String saveBookToList(@ModelAttribute Book kirja) {
        books.add(kirja);
        return "redirect:/friend";
    }



}
