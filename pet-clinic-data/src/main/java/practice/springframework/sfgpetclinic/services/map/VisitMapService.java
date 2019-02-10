package practice.springframework.sfgpetclinic.services.map;

import practice.springframework.sfgpetclinic.model.Pet;
import practice.springframework.sfgpetclinic.model.Visit;
import practice.springframework.sfgpetclinic.services.VisitService;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile(value = {"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Visit save(Visit visit) {
        Pet pet = visit.getPet();
        if (pet == null || pet.getId() == null || pet.getOwner() == null || pet.getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit");
        }

        return super.save(visit);
    }
}
