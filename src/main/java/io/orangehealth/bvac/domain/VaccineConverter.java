package io.orangehealth.bvac.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class VaccineConverter implements AttributeConverter<Vaccine, String> {

	@Override
	public String convertToDatabaseColumn(Vaccine vaccine) {
		return vaccine.getName();
	}

	@Override
	public Vaccine convertToEntityAttribute(String dbData) {
		return Vaccine.findByVaccineName(dbData);
	}
	

}
