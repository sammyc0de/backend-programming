package syksy26.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import syksy26.bookstore.domain.Book;
import syksy26.bookstore.domain.BookRepository;

import syksy26.bookstore.domain.Category;
import syksy26.bookstore.domain.CategoryRepository;

import syksy26.bookstore.domain.AppUser;
import syksy26.bookstore.domain.AppUserRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	//Demo data tietokantaan
	//Kommentoitu pois käytöstä jotta testit menevät läpi

/*     @Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, AppUserRepository userRepository ) {
	return (args) -> {

			Category category1 = new Category("Educational");
			Category category2 = new Category("Classics");
			Category category3 = new Category("Comics");
			
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);

			bookRepository.save(new Book("Example Book", "Robert Author", 2026, "9780156-48", 29.90, category2));

			bookRepository.save(new Book("Nature Book", "Philip Downing", 2021, "358756-48", 19.90, category1));

			// Create users admin/admin and user/user
			AppUser user1 = new AppUser("user", "$2a$10$1nzWR.4DwZRUm3rdhNCkSOklsyCphKp1Ydkq3lETnPx99oAa3F9Ti","user@mail.com", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$3JleYlauJBlqY47vqfbj4.xAJ.0QIhpQW5A1U0r2fNQK7kXj3V.hq", "admin@mail.com", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			log.info("fetch all users");
			for (AppUser user : userRepository.findAll()) {
				log.info(user.toString());
			}		

		}; 

	} */

}
