package spring22;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
// import runwith
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import spring22.bookstore.domain.User;
import spring22.bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository urepository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User user = urepository.findByUsername("admin");
		assertThat(user).isNotNull();
		assertThat(user.getRole()).isEqualTo("ADMIN");
	}
	
	@Test
	public void createUser() {
		User user = new User("stargazers", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "stargazers@bookstore.fi");
		urepository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		urepository.delete(urepository.findByUsername("user"));
		User user = urepository.findByUsername("user");
		assertThat(user).isNull();
	}
}
