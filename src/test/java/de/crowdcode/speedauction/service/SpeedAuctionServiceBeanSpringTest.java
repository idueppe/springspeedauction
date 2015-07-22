package de.crowdcode.speedauction.service;

import de.crowdcode.speedauction.config.JavaConfig;
import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.domain.DetailProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JavaConfig.class})
public class SpeedAuctionServiceBeanSpringTest {

    @Autowired
    @Qualifier("speedAuctionService")
    private SpeedAuctionService service;

    @Test
    public void testRegisterAndFind() throws Exception {
        DetailProduct detailProduct = new DetailProduct();
        detailProduct //
                .withDescription("Description") //
                .withTitle("Title") //
                .withMinAmount(BigDecimal.ONE);

        LocalDateTime expireAt = LocalDateTime.now().plusHours(2);


        Long auctionId = service.registerProduct(detailProduct, expireAt);
        assertThat(auctionId, is(notNullValue()));

        List<Auction> auctions = service.findAllRunningAuctions();
        assertThat(auctions, hasSize(1));
    }
}