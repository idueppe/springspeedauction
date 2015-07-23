package de.crowdcode.speedauction.repository.datajpa;

import de.crowdcode.speedauction.domain.Auction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class AuctionRepositoryDataJpaImpl implements AuctionRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Auction> findExpiredAuctions() {
        TypedQuery<Auction> query = em.createNamedQuery(Auction.FIND_EXPIRED, Auction.class);
        query.setParameter("now", LocalDateTime.now());
        return query.getResultList();
    }

    @Override
    public List<Auction> findRunningAuctions() {
        TypedQuery<Auction> query = em.createNamedQuery(Auction.FIND_RUNNING, Auction.class);
        query.setParameter("now", LocalDateTime.now());
        return query.getResultList();
    }

}
