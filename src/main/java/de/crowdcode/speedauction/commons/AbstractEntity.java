package de.crowdcode.speedauction.commons;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public abstract class AbstractEntity implements Identifiable {

    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
