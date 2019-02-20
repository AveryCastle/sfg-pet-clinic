package practice.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import practice.springframework.sfgpetclinic.model.Owner;
import practice.springframework.sfgpetclinic.repositories.OwnerRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    private final String LAST_NAME = "Lilly";

    private final long ID = 1L;

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerSDJpaService ownerSDJpaService;

    private Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(LAST_NAME)).thenReturn(owner);

        Owner foundOne = ownerSDJpaService.findByLastName(LAST_NAME);
        assertEquals(Long.valueOf(ID), foundOne.getId());
        verify(ownerRepository, times(1)).findByLastName(LAST_NAME);
    }

    @Test
    void findById() {
        when(ownerRepository.findById(ID)).thenReturn(Optional.of(owner));

        Owner foundOne = ownerSDJpaService.findById(ID);
        assertEquals(LAST_NAME, foundOne.getLastName());
        verify(ownerRepository, times(1)).findById(ID);
    }

    @Test
    void findAll() {
        Set<Owner> owers = new HashSet<>();
        owers.add(owner);
        owers.add(Owner.builder().id(2L).firstName("Petter").build());
        when(ownerRepository.findAll()).thenReturn(owers);

        Set<Owner> all = ownerSDJpaService.findAll();
        assertNotNull(all);
        assertEquals(2, all.size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(ID).lastName(LAST_NAME).build();
        when(ownerRepository.save(any())).thenReturn(owner);

        Owner savedOne = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOne);
        assertEquals(Long.valueOf(ID), savedOne.getId());
    }

    @Test
    void deleteById() {
        ownerRepository.deleteById(ID);

        verify(ownerRepository, times(1)).deleteById(ID);
    }

    @Test
    void delete() {
        ownerRepository.delete(owner);

        verify(ownerRepository, times(1)).delete(owner);
    }
}
