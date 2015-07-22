package de.crowdcode.speedauction.domain;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class DetailProduct extends Product {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DetailProduct withDescription(final String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "DetailProduct{" +
                "description='" + description + '\'' +
                " --> " + super.toString() +
                '}';
    }
}
