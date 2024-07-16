package br.com.digitalinnovationone.api_visitor.validation;

import br.com.digitalinnovationone.api_visitor.exception.InvalidCpfException;
import br.com.digitalinnovationone.api_visitor.exception.InvalidNameException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandlerException {
  private Error mountErrorInstance(RuntimeException e) {
    return Error.builder()
        .dateTime(LocalDateTime.now())
        .message(e.getMessage())
        .build();
  }
  
  @ExceptionHandler(InvalidCpfException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Error handleInvalidCpfException(InvalidCpfException e) {
    return mountErrorInstance(e);
  }
  
  @ExceptionHandler(InvalidNameException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Error handleInvalidNameException(InvalidNameException e) {
    return mountErrorInstance(e);
  }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class Error {
  private LocalDateTime dateTime;
  private String message;
}
