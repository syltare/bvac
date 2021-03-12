package io.orangehealth.bvac.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.orangehealth.bvac.domain.VaccineInjection;
import io.orangehealth.bvac.service.VaccineInjectionService;

/**
 * Vaccine Injection Controller
 * 
 * @author Rafael Rodrigues
 */

@RestController
@RequestMapping(path = "/api/vaccineInjections")
public class VaccineInjectionController {
	@Autowired
	private VaccineInjectionService vaccineInjectionService;

	/**
	 * Vaccine Injection Registration Endpoint
	 * 
	 * @param RegisterVaccination object
	 * @return HTTP status 201 if success, HTTP 400 if fails
	 */
	@PostMapping(path = "/register")
	@ResponseStatus(HttpStatus.CREATED)
	public VaccineInjection register(@Valid @RequestBody RegisterVaccinationDto registerVaccinationDto) {
		return vaccineInjectionService
				.register(registerVaccinationDto.getVaccineName(), registerVaccinationDto.getInjectionDate(),
						registerVaccinationDto.getCpf())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"No user bind to this CPF registered."));
	}
}