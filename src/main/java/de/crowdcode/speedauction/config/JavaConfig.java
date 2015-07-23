package de.crowdcode.speedauction.config;

import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.domain.Product;
import de.crowdcode.speedauction.repository.AuctionRepository;
import de.crowdcode.speedauction.repository.inmemory.AuctionRepositoryInMemory;
import de.crowdcode.speedauction.repository.inmemory.InMemoryStore;
import de.crowdcode.speedauction.service.SpeedAuctionService;
import de.crowdcode.speedauction.service.SpeedAuctionServiceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
public class JavaConfig {

    private static final Logger log = LoggerFactory.getLogger(JavaConfig.class);

    /**
     * <bean id="speedAuctionService" class="de.crowdcode.speedauction.service.SpeedAuctionServiceBean">
     *   <constructor-arg ref="auctionRepository"/> ??? 
     * </bean>
     * @param auctionRepository
     * @return
     */
    @Bean
    public SpeedAuctionService speedAuctionService(AuctionRepository auctionRepository) {
        log.info("=| Creating new AuctionService Instance");
        SpeedAuctionServiceBean serviceBean = new SpeedAuctionServiceBean(auctionRepository);
        return serviceBean;
    }
}
