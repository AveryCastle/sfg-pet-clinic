package practice.springframework.sfgpetclinic.services;

import practice.springframework.sfgpetclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long> {

    Vet findByLastName(String lastName);
}
