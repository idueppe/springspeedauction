package de.crowdcode.speedauction.domain;

import de.crowdcode.speedauction.commons.AbstractEntity;

import java.math.BigDecimal;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class Bid extends AbstractEntity{

    private BigDecimal amount;

    private String email;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Bid withAmount(final BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Bid withEmail(final String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "amount=" + amount +
                ", email='" + email + '\'' +
                '}';
    }
}

