package io.orangehealth.bvac.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import io.orangehealth.bvac.domain.VaccineInjection;

public class RegisterUserDto {
	@NotBlank(message = "First name is a required field.")
	private String firstName;
	
	private String lastName;
	
	@NotBlank(message = "E-mail is a required field.")
	@Email(message = "Invalid e-mail")
	private String email;
	
	@NotBlank(message = "CPF is a required field")
	@Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", message = "000.000.000-00 must be the specified format for CPF.")
	private String cpf;
	
	@NotNull(message = "Birth date is a required field.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	
	private List<VaccineInjection> vaccines = new ArrayList<>();
	
	public RegisterUserDto(String firstName, String lastName, String email, String cpf, LocalDate birthDate,
			VaccineInjection vaccines) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.vaccines = Arrays.asList(vaccines);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<VaccineInjection> getVaccines() {
		return vaccines;
	}

	public void setVaccines(List<VaccineInjection> vaccines) {
		this.vaccines = vaccines;
	}
}