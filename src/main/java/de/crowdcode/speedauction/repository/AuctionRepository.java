package de.crowdcode.speedauction.repository;

import de.crowdcode.speedauction.domain.Auction;

import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface AuctionRepository {

    /**
     * Find all auctions
     * @return List of Auction objects
     */
    List<Auction> findAll();


    /**
     * @param auction object to be save or update
     */
    void save(Auction auction);

}
