package spring22.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import spring22.bookstore.domain.Book;
import spring22.bookstore.domain.BookstoreRepository;

import spring22.bookstore.domain.Category;
import spring22.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner Bookstore(BookstoreRepository brepository, CategoryRepository crepository) {
		return (args) -> {

			crepository.save(new Category("Self-help"));
			crepository.save(new Category("fanatsy"));
			crepository.save(new Category("comedies"));
			crepository.save(new Category("science_fiction"));

			brepository.save(new Book("Ryan Holiday", "The obstacle is the way", "281-31-1346-6",
					"2021", crepository.findByName("Self-help").get(0)));

			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
