package br.com.digitalinnovationone.api_visitor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class ApiVisitorApplicationTests {

	@Test
	void contextLoads() {
		assertDoesNotThrow(() -> ApiVisitorApplication.main(new String[]{}));
	}

}
