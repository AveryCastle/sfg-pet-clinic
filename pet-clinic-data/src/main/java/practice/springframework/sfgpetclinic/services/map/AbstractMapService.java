package practice.springframework.sfgpetclinic.services.map;

import practice.springframework.sfgpetclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new TreeSet(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object == null) {
            throw new RuntimeException("Obejct can not be null.");
        }

        if (object.getId() == null) {
            object.setId(nextId());
        }

        return map.put(object.getId(), object);
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
    }

    private Long nextId() {
        Set<Long> idSet = map.keySet();
        if (idSet.isEmpty()) {
            return 1L;
        }
        return Collections.max(idSet) + 1;
    }
}
