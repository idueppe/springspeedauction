package de.crowdcode.speedauction.domain;

import de.crowdcode.speedauction.commons.AbstractEntity;

import java.math.BigDecimal;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class Product extends AbstractEntity {
    private String title;

    private BigDecimal minAmount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public Product withTitle(final String title) {
        this.title = title;
        return this;
    }

    public Product withMinAmount(final BigDecimal minAmount) {
        this.minAmount = minAmount;
        return this;
    }


    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", minAmount=" + minAmount +
                '}';
    }
}
