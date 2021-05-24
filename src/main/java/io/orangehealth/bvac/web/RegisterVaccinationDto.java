package io.orangehealth.bvac.web;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import io.orangehealth.bvac.domain.Vaccine;

/**
 * Register Vaccine DTO
 * 
 * @author Rafael Rodrigues
 */
public class RegisterVaccinationDto {
	@NotNull
	@NotNull(message = "Vaccine name is a required field.")
	private Vaccine vaccineName;
	
	@NotNull
	@NotNull(message = "Injection date is a required field.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate injectionDate;
	
	@NotNull
	private long id;
	
	public RegisterVaccinationDto(Vaccine vaccineName,LocalDate injectionDate, long id) {
		this.vaccineName = vaccineName;
		this.injectionDate = injectionDate;
		this.id = id;
	}
	public Vaccine getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(Vaccine vaccineName) {
		this.vaccineName = vaccineName;
	}
	public LocalDate getInjectionDate() {
		return injectionDate;
	}
	public void setInjectionDate(LocalDate injectionDate) {
		this.injectionDate = injectionDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}	
}