package de.crowdcode.speedauction.repository.datajpa;

import de.crowdcode.speedauction.domain.Auction;

import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface AuctionRepositoryCustom {

    List<Auction> findExpiredAuctions();

    List<Auction> findRunningAuctions();
}
