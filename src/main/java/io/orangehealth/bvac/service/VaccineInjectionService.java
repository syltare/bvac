package io.orangehealth.bvac.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.orangehealth.bvac.domain.VaccineInjection;
import io.orangehealth.bvac.repository.VaccineInjectionRepository;
import io.orangehealth.bvac.web.RegisterVaccinationDto;

/**
 * Vaccine Injection Service
 * 
 * @author Rafael Rodrigues
 */

@Service
public class VaccineInjectionService {
	private UserService userService;
	private VaccineInjectionRepository vaccineInjectionRepository;

	public VaccineInjectionService(UserService userService,
			VaccineInjectionRepository vaccineInjectionRepository) {
		this.userService = userService;
		this.vaccineInjectionRepository = vaccineInjectionRepository;
	}

	public RegisterVaccinationDto register(RegisterVaccinationDto registerVaccinationDto) {
		Optional<VaccineInjection> vaccineInjection = Optional.empty();
		if (userService.findById(registerVaccinationDto.getId()).isPresent()) {
			vaccineInjection = Optional.of(vaccineInjectionRepository
					.save(new VaccineInjection(registerVaccinationDto.getVaccineName(), registerVaccinationDto.getInjectionDate(),
						 userService.findById(registerVaccinationDto.getId()).get())));
		} else {
			vaccineInjection.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"No user bind to this CPF."));
		}
		return registerVaccinationDto;
	}
}