package br.com.digitalinnovationone.api_visitor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Creates all get-setters, toString and hash codes
@NoArgsConstructor // Creates a constructor without any args
@AllArgsConstructor // Creates a constructor with all args
@Builder // Design pattern that builds the class progressively
public class VisitorRequestDto {
  private String cpf;
  private String name;
}
