package br.com.digitalinnovationone.api_visitor.controller;

import br.com.digitalinnovationone.api_visitor.dto.VisitorRequestDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.with;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
// Generate a random port
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestVisitorController {
  
  @LocalServerPort
  private int port;
  
  @BeforeEach
  void setup() {
    // attribute that random port to my tests before each test
    RestAssured.port = port;
  }
  
  @Test
  void shouldSendRequestToCreateUserWithSuccess() {
    var endpoint = "/visitors";
    var method = "POST";

    var cpf = "11111111111";
    var name = "Visitor from DIO";
    // data transfer object, used for transferring data from one layer to another
    var payload = new VisitorRequestDto(cpf, name);

    var response = with()
        .contentType(ContentType.JSON)
        .body(payload)
        .request(method, endpoint)
        .then()
        .extract()
        .response();

    var json = response.jsonPath();

    // Tests everything even though a test has thrown an error
    assertAll("all tests",
        () -> assertEquals(HttpStatus.CREATED.value(), response.getStatusCode()),
        () -> assertNotNull(json.getString("id"))
    );
  }

  @Test
  void shouldSendRequestToCreateUserButReturnsEmptyCPF() {
    var endpoint = "/visitors";
    var method = "POST";
    
    var name = "Visitor from DIO";
    var payload = new VisitorRequestDto(null, name);
    
    var response = with()
        .contentType(ContentType.JSON)
        .body(payload)
        .request(method, endpoint)
        .then()
        .extract()
        .response();
    
    var json = response.jsonPath();
    
    assertAll("all tests",
        () -> assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode()),
        () -> assertNotNull(json.getString("dateTime")),
        () -> assertEquals("invalid or not informed CPF", json.getString("message"))
    );
  }
  
  @Test
  void shouldSendRequestToCreateUserButReturnsInvalidName() {
    var endpoint = "/visitors";
    var method = "POST";
    
    var cpf = "06556844179";
    var payload = new VisitorRequestDto(cpf, null);
    
    var response = with()
        .contentType(ContentType.JSON)
        .body(payload)
        .request(method, endpoint)
        .then()
        .extract()
        .response();
    
    var json = response.jsonPath();
    
    assertAll("all tests",
        () -> assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode()),
        () -> assertNotNull(json.getString("dateTime")),
        () -> assertEquals("invalid or not informed name", json.getString("message"))
    );
  }
}
