package practice.springframework.sfgpetclinic.repositories;

import practice.springframework.sfgpetclinic.model.Pet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
