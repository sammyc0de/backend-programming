package syksy26.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import syksy26.bookstore.domain.Book;
import syksy26.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner data(BookRepository repository) {
	return (args) -> {
	  repository.save(new Book(
					 "Example Book",
					 "Robert Author",
					 "9780156450884",
					 2026,
					 29.99
				 ));
	};
}

}
