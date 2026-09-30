package syksy26.bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import syksy26.bookstore.domain.Book;
import syksy26.bookstore.domain.BookRepository;

import syksy26.bookstore.domain.Category;
import syksy26.bookstore.domain.CategoryRepository;

@DataJpaTest
public class BookRepositoryTest {
    
    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;
  

    @Test
    public void findByAuthorShouldReturnBook() {
        
        List<Book> books = repository.findByAuthor("Tim Walls");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle())
        .isEqualTo("Modern operating systems");
    }

    @Test
    public void createNewBook() {

        Category category = new Category("Science");			
		crepository.save(category);

        Book book = new Book("1000 stars", "Billy Johnson", 2001, "5890156-42", 35.50, category);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteNewBook() {
        List<Book> books = repository.findByAuthor("Tim Walls");
        Book book = books.get(0);
        repository.delete(book);
        List<Book> newBooks = repository.findByAuthor("Tim Walls");
        assertThat(newBooks).hasSize(0);
    }
 

}
