package de.crowdcode.speedauction.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.domain.DetailProduct;
import de.crowdcode.speedauction.repository.AuctionRepository;

/**
 * @author Ingo Düppe (Crowdcode)
 */

// @Component
public class SpeedAuctionServiceBean implements SpeedAuctionService {

	@Autowired
	private Optional<AuctionRepository> auctionRepository;

//    public SpeedAuctionServiceBean() {
//    }

//    @Autowired
//	public SpeedAuctionServiceBean(AuctionRepository auctionRepository) {
//		this.auctionRepository = Optional.of(auctionRepository);
//	}

	@Override
	public Long registerProduct(DetailProduct detail, LocalDateTime expireAt) {
		return null;
	}

	@Override
	public List<Auction> findAllRunningAuctions() {
		return auctionRepository.get().findAll();
	}

//	@Autowired
	public void setAuctionRepository(AuctionRepository auctionRepository) {
		this.auctionRepository = Optional.ofNullable(auctionRepository);
	}
}
