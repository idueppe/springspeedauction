package de.crowdcode.speedauction.service;

import de.crowdcode.speedauction.config.JavaConfig;
import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.domain.DetailProduct;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class SpeedAuctionServiceBeanTest {

    @Test
    public void testJavaConfigByName() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(JavaConfig.class);
        ctx.refresh();

        SpeedAuctionService service = ctx.getBean(SpeedAuctionService.class);

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