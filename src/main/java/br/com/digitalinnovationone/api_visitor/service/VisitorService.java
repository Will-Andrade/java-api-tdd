package br.com.digitalinnovationone.api_visitor.service;

import br.com.digitalinnovationone.api_visitor.dto.VisitorRequestDto;
import br.com.digitalinnovationone.api_visitor.entity.Visitor;
import br.com.digitalinnovationone.api_visitor.repository.VisitorRepository;
import br.com.digitalinnovationone.api_visitor.validation.VisitorValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VisitorService {
  private final VisitorRepository repository;
  
  public Visitor create(VisitorRequestDto dto) {
    VisitorValidation.validateVisitorCreation(dto);
    
    var id = UUID.randomUUID().toString();
    var visitor = new Visitor(id, dto.getCpf(), dto.getName());
    return repository.save(visitor);
  }
}
