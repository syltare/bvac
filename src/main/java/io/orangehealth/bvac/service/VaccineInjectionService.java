package io.orangehealth.bvac.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.orangehealth.bvac.domain.Vaccine;
import io.orangehealth.bvac.domain.VaccineInjection;
import io.orangehealth.bvac.repository.UserRepository;
import io.orangehealth.bvac.repository.VaccineInjectionRepository;

/**
 * Vaccine Injection Service
 * 
 * @author Rafael Rodrigues
 */

@Service
public class VaccineInjectionService {
	private UserRepository userRepository;
	private VaccineInjectionRepository vaccineInjectionRepository;

	@Autowired
	public VaccineInjectionService(UserRepository userRepository,
			VaccineInjectionRepository vaccineInjectionRepository) {
		this.userRepository = userRepository;
		this.vaccineInjectionRepository = vaccineInjectionRepository;
	}

	/**
	 * Creates and saves a vaccine injection
	 * 
	 * @param vaccineName
	 * @param injectionDate
	 * @param cpf
	 * @return Optional of vaccine injection, empty if user don't exist
	 */
	public Optional<VaccineInjection> register(Vaccine vaccineName, LocalDate injectionDate, String cpf) {
		Optional<VaccineInjection> vaccineInjection = Optional.empty();
		if (userRepository.findByCpf(cpf).isPresent()) {
			vaccineInjection = Optional.of(vaccineInjectionRepository
					.save(new VaccineInjection(vaccineName, injectionDate, userRepository.findByCpf(cpf).get())));
		}
		return vaccineInjection;
	}
}
