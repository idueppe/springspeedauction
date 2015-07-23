package de.crowdcode.speedauction.service;

import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.domain.DetailProduct;
import de.crowdcode.speedauction.repository.AuctionRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */

// @Component
@Transactional
public class SpeedAuctionServiceBean implements SpeedAuctionService {

    private AuctionRepository auctionRepository;

    public SpeedAuctionServiceBean(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public Long registerProduct(DetailProduct detail, LocalDateTime expireAt) {
        Auction auction = new Auction()
                .withProduct(detail)
                .withExpireAt(expireAt)
                .withOwner("not@implemented.yet");
        auctionRepository.save(auction);
        return auction.getId();
    }

    @Override
    public List<Auction> findAllRunningAuctions() {
        // FIXME filter expired auctions
        return auctionRepository.findAll();
    }

}
