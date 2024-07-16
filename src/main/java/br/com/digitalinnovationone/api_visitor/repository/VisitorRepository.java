package br.com.digitalinnovationone.api_visitor.repository;

import br.com.digitalinnovationone.api_visitor.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                            // entity, primaryKey
public interface VisitorRepository extends JpaRepository<Visitor, String> {
}
