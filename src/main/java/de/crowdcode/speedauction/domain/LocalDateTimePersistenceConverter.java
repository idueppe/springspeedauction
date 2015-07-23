package de.crowdcode.speedauction.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Converter(autoApply = true)
public class LocalDateTimePersistenceConverter implements
        AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public java.sql.Timestamp convertToDatabaseColumn(LocalDateTime entityValue) {
        if (entityValue != null) {
            return Timestamp.valueOf(entityValue);
        } else {
            return null;
        }
    }

    @Override
    public LocalDateTime convertToEntityAttribute(
            java.sql.Timestamp databaseValue) {
        if (databaseValue != null) {
            return databaseValue.toLocalDateTime();
        } else {
            return null;
        }
    }
}