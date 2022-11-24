package spring22;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import spring22.bookstore.domain.Category;
import spring22.bookstore.domain.CategoryRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = crepository.findByName("Satire");
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Satire");
	}
	
	@Test
	public void createCategory() {
		Category category = new Category("Science");
		crepository.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		crepository.delete(crepository.findByName("Horror").get(0));
		List<Category> categories = crepository.findByName("Science");
		assertThat(categories).hasSize(0);
	}
}
