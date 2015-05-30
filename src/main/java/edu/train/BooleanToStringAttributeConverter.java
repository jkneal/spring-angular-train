package edu.train;

import javax.persistence.AttributeConverter;

public class BooleanToStringAttributeConverter implements AttributeConverter<Boolean, String> {
	
	private static final String TRUE_VALUE = "Y";
	private static final String FALSE_VALUE = "N";

	@Override
	public String convertToDatabaseColumn(Boolean attribute) {
		return attribute ? TRUE_VALUE : FALSE_VALUE;
	}

	@Override
	public Boolean convertToEntityAttribute(String dbData) {
		return dbData.equals(TRUE_VALUE);
	}

}
