package practice.springframework.sfgpetclinic.services.map;

import practice.springframework.sfgpetclinic.model.Owner;
import practice.springframework.sfgpetclinic.model.Pet;
import practice.springframework.sfgpetclinic.model.PetType;
import practice.springframework.sfgpetclinic.services.OwnerSerivce;
import practice.springframework.sfgpetclinic.services.PetService;
import practice.springframework.sfgpetclinic.services.PetTypeService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile(value = {"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerSerivce {

    private final PetTypeService petTypeService;

    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner == null) return null;
        if (owner.getPets() == null) return super.save(owner);

        owner.getPets().stream().forEach(pet -> {
            savePetTypeConditional(pet.getPetType());
            savePetConditional(pet);
        });

        return super.save(owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    private void savePetConditional(Pet pet) {
        if (pet.getId() == null) {
            petService.save(pet);
        }
    }

    private void savePetTypeConditional(PetType petType) {
        if (petType != null && petType.getId() != null) {
            petTypeService.save(petType);
        }
    }
}
