package de.crowdcode.speedauction.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@Import({JpaConfig.class, DataSourceConfig.class})
@EnableJpaRepositories(value = "de.crowdcode.speedauction.repository.datajpa")
public class AuctionRepositoryDataJpaConfig {

}
