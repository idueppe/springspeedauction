package de.crowdcode.speedauction.repository.datajpa;

import de.crowdcode.speedauction.config.AuctionRepositoryDataJpaConfig;
import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.domain.DetailProduct;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AuctionRepositoryDataJpaConfig.class)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuctionRepositoryDataJpaTest {

    @Autowired
    private AuctionRepositoryDataJpa auctionRepository;

    @Test
    @Rollback(false)
    public void test_1_persist() throws Exception {

        DetailProduct detailProduct = new DetailProduct();
        detailProduct //
                .withDescription("Description") //
                .withTitle("Title") //
                .withMinAmount(BigDecimal.ONE);

        Auction auction = new Auction()
                .withProduct(detailProduct)
                .withExpireAt(LocalDateTime.now().minusHours(1))
                .withOwner("owner@junit.test");

        auctionRepository.save(auction);
    }

    @Test
    public void test_2_find_by_owner() throws Exception {
        Optional<Auction> auction = auctionRepository.findByOwner("owner@junit.test");
        assertThat(auction.get().getOwner(), is("owner@junit.test"));
    }

    @Test
    public void test_3_find_by_title() throws Exception {
        Auction auction = auctionRepository.findByProductTitle("Title");
        assertThat(auction.getProduct().getTitle(), is("Title"));
    }

    @Test
    public void test_4_find_expired() throws Exception {
        List<Auction> auctions = auctionRepository.findExpiredAuctions();
        assertThat(auctions, hasSize(1));
    }

    @Test
    public void test_5_find_running() throws Exception {
        List<Auction> auctions = auctionRepository.findRunningAuctions();
        assertThat(auctions, hasSize(0));
    }
}