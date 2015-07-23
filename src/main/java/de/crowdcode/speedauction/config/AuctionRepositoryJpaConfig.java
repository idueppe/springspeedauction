package de.crowdcode.speedauction.config;

import de.crowdcode.speedauction.repository.AuctionRepository;
import de.crowdcode.speedauction.repository.jpa.AuctionRepositoryJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@Import({JpaConfig.class, DataSourceConfig.class})
public class AuctionRepositoryJpaConfig {

    @Bean
    public AuctionRepository auctionRepository() {
        return new AuctionRepositoryJPA();
    }

}
