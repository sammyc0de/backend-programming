package syksy26.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import syksy26.bookstore.web.BookController;
import syksy26.bookstore.web.BookRestController;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private BookController bookController;
	@Autowired

	private BookRestController restBookController;

	@Test
	void contextLoads() {
	}

	@Test
	public void bookControllerLoad() throws Exception {
		assertThat(bookController).isNotNull();
	}

	@Test
	public void restBookControllerLoad() throws Exception {
		assertThat(restBookController).isNotNull();
	}


}
