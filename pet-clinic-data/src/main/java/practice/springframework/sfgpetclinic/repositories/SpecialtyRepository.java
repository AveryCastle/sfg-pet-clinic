package practice.springframework.sfgpetclinic.repositories;

import practice.springframework.sfgpetclinic.model.Specialty;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
