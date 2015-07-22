package de.crowdcode.speedauction.repository.inmemory;


import de.crowdcode.speedauction.commons.Identifiable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryStore<T extends Identifiable> {

    private static final Logger logger = LoggerFactory
            .getLogger(InMemoryStore.class);

    private Map<Long, T> store;

    private Long sequence = 0l;

    public InMemoryStore() {
        store = new HashMap<Long, T>();
    }

    public void init() {
        logger.info("init in memory store");
        sequence = System.currentTimeMillis();
    }

    public void save(T entity) {
        if (entity.getId() == null) {
            entity.setId(nextId());
        }
        store.put(entity.getId(), entity);
    }

    public void delete(long id) {
        store.remove(id);
    }

    public List<T> loadAll() {
        return new ArrayList<T>(store.values());
    }

    public T load(long id) {
        return store.get(id);
    }

    synchronized public long nextId() {
        return sequence++;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public void clear() {
        store.clear();
    }
}