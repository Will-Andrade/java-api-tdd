package br.com.digitalinnovationone.api_visitor.exception;

public class InvalidCpfException extends RuntimeException {
  public InvalidCpfException() {
    super("invalid or not informed CPF");
  }
}
