package br.com.digitalinnovationone.api_visitor.controller;

import br.com.digitalinnovationone.api_visitor.dto.VisitorRequestDto;
import br.com.digitalinnovationone.api_visitor.entity.Visitor;
import br.com.digitalinnovationone.api_visitor.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // tells spring boot that this class will expose its endpoints
@RequestMapping("/visitors") // defines the URL for this endpoint
@RequiredArgsConstructor
public class VisitorController {
  private final VisitorService service; // only injects the service when I use the class
  
  @PostMapping // @RequestBody to get it from the front end
  @ResponseStatus(HttpStatus.CREATED)
  public Visitor create(@RequestBody VisitorRequestDto dto) {
    return service.create(dto); // where the business logic lies
  }
}
