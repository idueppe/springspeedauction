package de.crowdcode.speedauction.repository.inmemory;

import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.repository.AuctionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionRepositoryInMemory implements AuctionRepository {
    @Override
    public List<Auction> findAll() {
        return null;
    }

    @Override
    public void save(Auction auction) {

    }
}
