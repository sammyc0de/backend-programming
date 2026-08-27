package syksy26.bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import syksy26.bookstore.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class BookController {

    public static final List<Book> books = new ArrayList<>();

  
    @GetMapping("/index")
    public String showBooks(Model model) {
        model.addAttribute("books", books);
        return "bookList";
    }

}
