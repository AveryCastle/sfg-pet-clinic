package practice.springframework.sfgpetclinic.repositories;

import practice.springframework.sfgpetclinic.model.Visit;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
