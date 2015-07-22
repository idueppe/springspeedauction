package de.crowdcode.speedauction.config;

import de.crowdcode.speedauction.service.SpeedAuctionService;
import de.crowdcode.speedauction.service.SpeedAuctionServiceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@ComponentScan(basePackages = {"de.crowdcode.speedauction.service",
        "de.crowdcode.speedauction.repository.inmemory"})
public class JavaConfig {

    @Bean
    public SpeedAuctionService speedAuctionServiceXXY() {
        return new SpeedAuctionServiceBean();
    }
}
