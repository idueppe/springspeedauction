package de.crowdcode.speedauction.repository.jpa;

import de.crowdcode.speedauction.domain.Auction;
import de.crowdcode.speedauction.repository.AuctionRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionRepositoryJPA implements AuctionRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Auction> findAll() {
        TypedQuery<Auction> query = em.createNamedQuery(Auction.FIND_ALL, Auction.class);
        return query.getResultList();
    }

    @Override
    public void save(Auction auction) {
        em.persist(auction);
    }
}
