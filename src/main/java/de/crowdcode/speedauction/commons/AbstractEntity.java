package de.crowdcode.speedauction.commons;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.util.Date;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@MappedSuperclass
public abstract class AbstractEntity implements Identifiable {

    @Id
    @GeneratedValue
    private Long id;


    @Version
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastUpdate() {
        return (Date) lastUpdate.clone();
    }
}
