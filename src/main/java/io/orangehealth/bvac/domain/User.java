package io.orangehealth.bvac.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User Entity
 * 
 * @author Rafael Rodrigues
 */

@Entity
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;
	
	@Column(name = "first_name")
	@NotBlank(message = "First name is a required field.")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email", unique = true)
	@NotBlank(message = "E-mail is a required field.")
	@Email(message = "Invalid e-mail")
	private String email;
	
	@Column(name = "cpf", unique = true)
	@NotBlank(message = "CPF is a required field")
	@Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", message = "000.000.000-00 must be the specified format for CPF.")
	private String cpf;
	
	@Column(name = "birth_date")
	@NotNull(message = "Birth date is a required field.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("user")
	private List<VaccineInjection> vaccines = new ArrayList<>();
	
	/**
	 * Default Constructor
	 */
	protected User() {};
	
	/**
	 * Constructor without VaccineInjection object
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param cpf
	 * @param birthDate
	 */
	public User( String firstName, String lastName, String email, String cpf, LocalDate birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}
	
	/**
	 * Complete Constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param cpf
	 * @param birthDate
	 * @param vaccine
	 */
	public User( String firstName, String lastName, String email, String cpf, LocalDate birthDate, VaccineInjection vaccine) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.vaccines = Arrays.asList(vaccine);
	}
	
	public void addVaccine(VaccineInjection vaccine) {
		vaccines.add(vaccine);
		vaccine.setUser(this);
	}
	
	public void removeVaccine(VaccineInjection vaccine) {
		vaccines.remove(vaccine);
		vaccine.setUser(null);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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