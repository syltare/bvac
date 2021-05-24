package io.orangehealth.bvac.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Vaccine Injection Entity
 * 
 * @author Rafael Rodrigues
 */

@Entity
@Table(name = "VACCINE_INJECTION")
public class VaccineInjection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vaccine_id")
	private long id;
	
	@Column(name = "vaccine_name")
	private Vaccine vaccineName;
	
	@Column(name = "injection_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate injectionDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
    @JsonIgnoreProperties("vaccines")
	private User user;
	
	/**
	 * Default Constructor
	 */
	protected VaccineInjection() {};
	
	/**
	 * Constructor without User object
	 * 
	 * @param vaccineName
	 * @param injectionDate
	 */
	public VaccineInjection(Vaccine vaccineName, LocalDate injectionDate) {
		super();
		this.vaccineName = vaccineName;
		this.injectionDate = injectionDate;
	}

	/**
	 * Complete Constructor
	 * 
	 * @param vaccineName
	 * @param administrationDate
	 * @param user
	 */
	public VaccineInjection(Vaccine vaccineName, LocalDate administrationDate, User user) {
		super();
		this.vaccineName = vaccineName;
		this.injectionDate = administrationDate;
		this.user = user;
	}
	
	/* TODO: Equality Consistency
	 * reference: https://web.archive.org/web/20170524072455/http://www.onjava.com/pub/a/onjava/2006/09/13/dont-let-hibernate-steal-your-identity.html?page=1
	 * 
	 * @Override
	 * public boolean equals(Object obj) {
	 *	// TODO Auto-generated method stub
	 *	return super.equals(obj);
	 * }
	 *
	 * @Override
	 * public int hashCode() {
	 *	// TODO Auto-generated method stub
	 *	return super.hashCode();
	 * }
	 */
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
