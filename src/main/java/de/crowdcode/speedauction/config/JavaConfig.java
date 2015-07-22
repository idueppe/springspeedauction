package de.crowdcode.speedauction.config;

import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.repository.AuctionRepository;
import de.crowdcode.speedauction.repository.inmemory.AuctionRepositoryInMemory;
import de.crowdcode.speedauction.service.SpeedAuctionService;
import de.crowdcode.speedauction.service.SpeedAuctionServiceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@ComponentScan(basePackages = {"de.crowdcode.speedauction.service"})
public class JavaConfig {

    private static final Logger log = LoggerFactory.getLogger(JavaConfig.class);

    // Variante 1



    @Bean
    public SpeedAuctionService speedAuctionService(Optional<AuctionRepository> auctionRepository) {
        log.info("=| Creating new AuctionService Instance");
        SpeedAuctionServiceBean serviceBean = new SpeedAuctionServiceBean();

        serviceBean.setAuctionRepository(auctionRepository.orElse(null));
//        serviceBean.setAuctionRepository(auctionRepository());
//        serviceBean.setAuctionRepository(auctionRepository());
        return serviceBean;
    }

//    @Bean
//    public AuctionRepository auctionRepository() {
//        log.info("=| Creating new AuctionRepository Instance");
//        return new AuctionRepositoryInMemory();
//    }

}
