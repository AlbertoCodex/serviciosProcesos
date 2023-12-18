package com.politecnico.main;

import com.politecnico.main.entity.Product;
import com.politecnico.main.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MainApplication.class, args);
		var repository = context.getBean(ProductRepository.class);
		List<Product> products=List.of(
				new Product(null, "product1", 5.99, 1),
				new Product(null, "product2", 6.99, 2),
				new Product(null, "product3", 7.99, 3),
				new Product(null, "product4", 8.99, 4)
		);
		repository.saveAll(products);
	}

}
