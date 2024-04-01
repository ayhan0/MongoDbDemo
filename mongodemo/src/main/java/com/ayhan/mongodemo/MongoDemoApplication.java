package com.ayhan.mongodemo;

import com.ayhan.mongodemo.category.Category;
import com.ayhan.mongodemo.category.CategoryRepository;
import com.ayhan.mongodemo.product.Product;
import com.ayhan.mongodemo.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			ProductRepository repository,
			CategoryRepository categoryRepository
	){
		return args -> {
			var category = Category.builder()
					.name("cat1")
					.description("cat2")
					.build();

			var category2 = Category.builder()
					.name("cat2")
					.description("cat3")
					.build();
			categoryRepository.insert(category);
			categoryRepository.insert(category2);
			var product = Product.builder()
			.name("Iphone")
					.description("Smart Iphone")
					.build();
			//repository.insert(product);
		};
	}
}
