package de.crowdcode.speedauction.repository.inmemory;

import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Repository
public class AuctionRepositoryInMemory implements AuctionRepository {

    @Autowired
    private InMemoryStore<Auction> inMemoryStore;

    @Override
    public List<Auction> findAll() {
        return inMemoryStore.loadAll();
    }

    @Override
    public void save(Auction auction) {
        inMemoryStore.save(auction);
    }
}
