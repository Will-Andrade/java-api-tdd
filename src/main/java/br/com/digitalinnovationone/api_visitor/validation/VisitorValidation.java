package br.com.digitalinnovationone.api_visitor.validation;

import br.com.digitalinnovationone.api_visitor.dto.VisitorRequestDto;
import br.com.digitalinnovationone.api_visitor.exception.InvalidCpfException;
import br.com.digitalinnovationone.api_visitor.exception.InvalidNameException;

import java.util.Optional;
import java.util.function.Predicate;

public class VisitorValidation {
  private VisitorValidation() {}
  
  public static void validateVisitorCreation(VisitorRequestDto dto) {
    Optional.ofNullable(dto.getCpf()).filter(Predicate.not(String::isEmpty)).orElseThrow(InvalidCpfException::new);
    Optional.ofNullable(dto.getName()).filter(Predicate.not(String::isEmpty)).orElseThrow(InvalidNameException::new);
  }
}
