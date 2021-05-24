package io.orangehealth.bvac.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import io.orangehealth.bvac.domain.User;

/**
 * User Repository
 * 
 * @author Rafael Rodrigues
 */

public interface UserRepository extends CrudRepository<User, Long>{
	Optional<User> findByEmail(String email);
	Optional<User> findById(long id);
	Optional<User> findByCpf(String cpf);
}