package io.orangehealth.bvac.repository;

import org.springframework.data.repository.CrudRepository;

import io.orangehealth.bvac.domain.VaccineInjection;

/**
 * Vaccine Injection Repository
 * 
 * @author Rafael Rodrigues
 */

public interface VaccineInjectionRepository extends CrudRepository<VaccineInjection, Long> {

}
