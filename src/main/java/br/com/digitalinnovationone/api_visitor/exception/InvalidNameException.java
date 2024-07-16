package br.com.digitalinnovationone.api_visitor.exception;

public class InvalidNameException extends RuntimeException {
  public InvalidNameException() {
    super("invalid or not informed name");
  }
}
