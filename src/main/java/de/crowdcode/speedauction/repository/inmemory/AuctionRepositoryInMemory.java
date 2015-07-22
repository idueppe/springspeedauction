package de.crowdcode.speedauction.repository.inmemory;

import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.repository.AuctionRepository;

import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionRepositoryInMemory implements AuctionRepository {

    private static InMemoryStore<Auction> inMemoryStore;

    public AuctionRepositoryInMemory(InMemoryStore<Auction> inMemoryStore) {
        this.inMemoryStore = inMemoryStore;
    }

    @Override
    public List<Auction> findAll() {
        return inMemoryStore.loadAll();
    }

    @Override
    public void save(Auction auction) {
        inMemoryStore.save(auction);
    }
}
