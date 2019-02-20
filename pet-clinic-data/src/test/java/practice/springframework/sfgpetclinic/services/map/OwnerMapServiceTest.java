package practice.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.springframework.sfgpetclinic.model.Owner;
import practice.springframework.sfgpetclinic.services.PetService;
import practice.springframework.sfgpetclinic.services.PetTypeService;

import java.util.Set;

class OwnerMapServiceTest {

    private OwnerMapService ownerMapService;

    private PetTypeService petTypeService;

    private PetService petService;

    private final Long id = 1L;

    private final String LAST_NAME = "Pete";

    @BeforeEach
    void setUp() {
        petTypeService = new PetTypeMapService();
        petService = new PetMapService();
        ownerMapService = new OwnerMapService(petTypeService, petService);

        ownerMapService.save(Owner.builder().id(id).firstName("Lilly").lastName(LAST_NAME).build());
    }

    @Test
    void findById() {
        Set<Owner> all = ownerMapService.findAll();
        assertEquals(1, all.size());
    }

    @Test
    void findAll() {
        Owner owner = ownerMapService.findById(id);
        assertEquals("Lilly", owner.getFirstName());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(id);

        Set<Owner> all = ownerMapService.findAll();
        assertEquals(0, all.size());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(LAST_NAME);
        assertEquals(id, owner.getId());
    }
}
