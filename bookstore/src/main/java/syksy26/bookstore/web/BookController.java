package syksy26.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import syksy26.bookstore.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import syksy26.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    public static final List<Book> books = new ArrayList<>();

  
    @GetMapping("/bookList")
    public String showBooks(Model model) {
        model.addAttribute("books", repository.findAll());
        return "bookList";
    }

   @RequestMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

   @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        repository.save(book);
        return "redirect:/bookList";
    }
 
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long bookId, Model model) {
        repository.deleteById(bookId);
        return "redirect:../bookList";    }


    


}
