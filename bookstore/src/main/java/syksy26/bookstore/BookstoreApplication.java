package syksy26.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import syksy26.bookstore.domain.Book;
import syksy26.bookstore.domain.BookRepository;

import syksy26.bookstore.domain.Category;
import syksy26.bookstore.domain.CategoryRepository;
 

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	//Demo data tietokantaan
    @Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
	return (args) -> {

			Category category1 = new Category("Educational");
			Category category2 = new Category("Classics");
			Category category3 = new Category("Comics");
			
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			bookRepository.save(new Book("Example Book", "Robert Author", 2026, "9780156-48", 29.90, category2));

			bookRepository.save(new Book("Nature Book", "Philip Downing", 2021, "358756-48", 19.90, category1));


			/* Book book1 = new Book("Example Book", "Robert Author", 2026, "9780156-48", 29.90, category2);
			bookRepository.save(book1);
			Book book2 = new Book("Nature Book", "Philip Downing", 2021, "358756-48", 19.90, category1);
			bookRepository.save(book2); */

			

		}; 

	}

}
