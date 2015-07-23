package de.crowdcode.speedauction.repository.datajpa;

import de.crowdcode.speedauction.domain.Auction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface AuctionRepositoryDataJpa extends CrudRepository<Auction, Long>, AuctionRepositoryCustom {
    Optional<Auction> findByOwner(String s);

    Auction findByProductTitle(String title);

    @Query("SELECT a FROM Auction a WHERE a.product.title = :title")
    List<Auction> findByTitle(@Param("title")String title);

}
