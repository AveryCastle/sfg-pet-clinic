package practice.springframework.sfgpetclinic.services;

import practice.springframework.sfgpetclinic.model.Owner;

public interface OwnerSerivce extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
