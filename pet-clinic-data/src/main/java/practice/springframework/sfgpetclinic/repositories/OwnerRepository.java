package practice.springframework.sfgpetclinic.repositories;

import practice.springframework.sfgpetclinic.model.Owner;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
