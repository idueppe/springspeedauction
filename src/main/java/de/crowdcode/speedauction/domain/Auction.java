package de.crowdcode.speedauction.domain;

import de.crowdcode.speedauction.commons.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Entity
public class Auction extends AbstractEntity{

    private String owner;

    private LocalDateTime expireAt;

    @OneToOne
    private Product product;

    @OneToOne
    private Bid highestBid;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Bid highestBid) {
        this.highestBid = highestBid;
    }

    public Auction withOwner(final String owner) {
        this.owner = owner;
        return this;
    }

    public Auction withExpireAt(final LocalDateTime expireAt) {
        this.expireAt = expireAt;
        return this;
    }

    public Auction withProduct(final Product product) {
        this.product = product;
        return this;
    }

    public Auction withHighestBid(final Bid highestBid) {
        this.highestBid = highestBid;
        return this;
    }


}
