package login.model.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {		
		
		return (attribute != null)? Timestamp.valueOf(attribute): null;
	}

	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp dbValue) {
		
		return (dbValue != null)? dbValue.toLocalDateTime(): null;
	}
	

}
