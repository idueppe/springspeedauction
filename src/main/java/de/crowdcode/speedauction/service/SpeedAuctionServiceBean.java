package de.crowdcode.speedauction.service;

import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.domain.DetailProduct;
import de.crowdcode.speedauction.repository.AuctionRepository;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Service("speedAuctionService")
public class SpeedAuctionServiceBean implements SpeedAuctionService, BeanNameAware, DisposableBean {

    @Autowired
    private AuctionRepository auctionRepository;

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

    @Override
    public void setBeanName(String name) {
        System.out.println("------------------- Mein Name ist "+name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("\n------------------- Bean wird entfernt!");
    }
}
