package clothingStore;

import clothingStore.entity.ProductRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClothingStoreSpringDemoSimpleJpaSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClothingStoreSpringDemoSimpleJpaSecurityApplication.class, args);
		System.out.println("Hello!");
	}

	@Bean
	public ApplicationRunner dataLoader(ProductRepository repo) {
		return args -> {
			repo.save(new Product("cl1", "Куртка", Product.Type.CLOTHING));
			repo.save(new Product("cl2", "Спортивный костюм", Product.Type.CLOTHING));
			repo.save(new Product("cl3", "Шорты", Product.Type.CLOTHING));
			repo.save(new Product("sh1", "Кроссовки", Product.Type.SHOES));
			repo.save(new Product("sh2", "Сапоги зимние", Product.Type.SHOES));
			repo.save(new Product("sh3", "Ботинки", Product.Type.SHOES));

		};
	}

}
