package io.orangehealth.bvac.web;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import io.orangehealth.bvac.domain.Vaccine;

public class RegisterVaccinationDto {
	@NotNull
	private Vaccine vaccineName;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate injectionDate;
	@NotNull
	@Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$")
	private String cpf;
	
	public RegisterVaccinationDto(Vaccine vaccineName,LocalDate injectionDate, String cpf) {
		this.vaccineName = vaccineName;
		this.injectionDate = injectionDate;
		this.cpf = cpf;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
