package de.crowdcode.speedauction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Configuration
@ComponentScan(basePackages = {"de.crowdcode.speedauction.service",
        "de.crowdcode.speedauction.repository.inmemory"})
public class JavaConfig {

//    @Bean(name="speedAuctionService")
//    public SpeedAuctionService speedAuctionServiceXXY() {
//        return new SpeedAuctionServiceBean();
//    }
}
