package practice.springframework.sfgpetclinic.repositories;

import practice.springframework.sfgpetclinic.model.Vet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {

    Vet findByLastName(String lastName);
}
