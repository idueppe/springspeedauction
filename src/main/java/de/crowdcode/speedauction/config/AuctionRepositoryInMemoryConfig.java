package de.crowdcode.speedauction.config;

import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.domain.Product;
import de.crowdcode.speedauction.repository.AuctionRepository;
import de.crowdcode.speedauction.repository.inmemory.AuctionRepositoryInMemory;
import de.crowdcode.speedauction.repository.inmemory.InMemoryStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionRepositoryInMemoryConfig {

    private static final Logger log = LoggerFactory.getLogger(JavaConfig.class);

    @Bean
    public AuctionRepository auctionRepository(InMemoryStore<Auction> inMemoryStore) {
        log.info("=| Creating new AuctionRepository Instance");
        return new AuctionRepositoryInMemory(inMemoryStore);
    }

    @Bean(initMethod = "init")
    public InMemoryStore<Auction> inMemoryStore() {
        log.info("=| Creating new InMemoryStore Instance");
        return new InMemoryStore<>();
    }

    @Bean(initMethod = "init")
    public InMemoryStore<Product> inMemoryStoreProduct() {
        log.info("=| Creating new InMemoryStore Instance");
        return new InMemoryStore<>();
    }
}
