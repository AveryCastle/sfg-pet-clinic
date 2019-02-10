package practice.springframework.sfgpetclinic.services.springdatajpa;

import practice.springframework.sfgpetclinic.model.Visit;
import practice.springframework.sfgpetclinic.repositories.VisitRepository;
import practice.springframework.sfgpetclinic.services.VisitService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Visit> findAll() {
        final Set<Visit> visitSet = new TreeSet<>();
        visitRepository.findAll().forEach(visitSet::add);
        return visitSet;
    }

    @Override
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }
}
