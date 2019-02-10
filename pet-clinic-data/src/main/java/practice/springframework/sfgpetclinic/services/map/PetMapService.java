package practice.springframework.sfgpetclinic.services.map;

import practice.springframework.sfgpetclinic.model.Pet;
import practice.springframework.sfgpetclinic.services.PetService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile(value = {"default", "map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public Pet findByLastName(String lastName) {
        Set<Pet> all = findAll();
        return all.stream()
                .filter(pet -> pet.getOwner().getLastName().equals(lastName))
                .findFirst().get();
    }
}
