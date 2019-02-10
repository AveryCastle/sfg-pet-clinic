package practice.springframework.sfgpetclinic.services.springdatajpa;

import practice.springframework.sfgpetclinic.model.Owner;
import practice.springframework.sfgpetclinic.repositories.OwnerRepository;
import practice.springframework.sfgpetclinic.services.OwnerSerivce;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerSerivce {

    private final OwnerRepository ownerRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Owner> findAll() {
        final Set<Owner> ownerSet = new TreeSet<>();
        ownerRepository.findAll().forEach(ownerSet::add);
        return ownerSet;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }
}
