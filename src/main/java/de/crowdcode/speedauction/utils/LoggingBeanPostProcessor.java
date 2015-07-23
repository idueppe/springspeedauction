package de.crowdcode.speedauction.utils;

import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.domain.DetailProduct;
import de.crowdcode.speedauction.service.SpeedAuctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Component
public class LoggingBeanPostProcessor implements BeanPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(LoggingBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("=| before Initialization of " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("=| after Initialization of " + beanName);
        if (bean instanceof SpeedAuctionService) {
            return new SpeedAuctionServiceInterceptor((SpeedAuctionService) bean);
        }
        return bean;
    }

    private class SpeedAuctionServiceInterceptor implements SpeedAuctionService {

        private final SpeedAuctionService target;

        public SpeedAuctionServiceInterceptor(SpeedAuctionService target) {
            this.target = target;
        }

        @Override
        public Long registerProduct(DetailProduct detail, LocalDateTime expireAt) {
            //
            return target.registerProduct(detail,expireAt);
        }

        @Override
        public List<Auction> findAllRunningAuctions() {
            //
            log.info("=| Find Running Auctions is called");
            return target.findAllRunningAuctions();
        }
    }
}
