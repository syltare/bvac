package io.orangehealth.bvac.web;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.orangehealth.bvac.service.VaccineInjectionService;

/**
 * Vaccine Injection Controller
 * 
 * @author Rafael Rodrigues
 */

@RestController
@RequestMapping(path = "/api/vaccineInjections")
public class VaccineInjectionController {
	private VaccineInjectionService vaccineInjectionService;
	
	public VaccineInjectionController(VaccineInjectionService vaccineInjectionService) {
		this.vaccineInjectionService = vaccineInjectionService;		
	}

	/**
	 * Vaccine Injection Registration Endpoint
	 * 
	 * @param RegisterVaccinationDTO object
	 * @return HTTP status 201 if success, HTTP 400 if fails
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RegisterVaccinationDto register(@Valid @RequestBody RegisterVaccinationDto registerVaccinationDto) {
		return vaccineInjectionService.register(registerVaccinationDto);
	}
}