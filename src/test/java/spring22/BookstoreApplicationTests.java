package spring22;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import spring22.bookstore.domain.UserRepository;
import spring22.bookstore.web.BookController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookController bcontroller;

	@Autowired
	private UserRepository ucontroller;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(bcontroller).isNotNull();
		assertThat(ucontroller).isNotNull();
	}

}
