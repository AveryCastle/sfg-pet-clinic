package practice.springframework.sfgpetclinic.services.springdatajpa;

import practice.springframework.sfgpetclinic.model.Specialty;
import practice.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import practice.springframework.sfgpetclinic.services.SpecialtyService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialtySet = new TreeSet<>();
        specialtyRepository.findAll().forEach(specialtySet::add);
        return specialtySet;
    }

    @Override
    public Specialty save(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }

    @Override
    public void delete(Specialty specialty) {
        specialtyRepository.delete(specialty);
    }
}
