package de.crowdcode.speedauction.service;

import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.domain.DetailProduct;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface SpeedAuctionService {


    /**
     * Register and start a new auction.
     * @param detail
     * @param expireAt
     * @return id of Auction
     */
    Long registerProduct(DetailProduct detail, LocalDateTime expireAt);

    /**
     * Find all currently running auctions.
     * @return List of auctions
     */
    List<Auction> findAllRunningAuctions();

}
