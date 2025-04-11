package com.model.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter( autoApply = false) // 如果想自動套用這個轉換器，設定 autoApply = true
public class GenderAttributeConverter implements AttributeConverter<Character, String>{ 
	
	//AttributeConverter<X, Y> 是將 X（Java 屬性）轉換為 Y（資料庫欄位類型）
	
	@Override
	public String convertToDatabaseColumn(Character attribute) {
		
		return attribute != null ? attribute.toString() : null;
	}

	@Override
	public Character convertToEntityAttribute(String dbData) {
		
		return (dbData != null && !dbData.isEmpty()) ? dbData.charAt(0) : null;
	} 




}
