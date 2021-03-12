package io.orangehealth.bvac.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.orangehealth.bvac.domain.User;
import io.orangehealth.bvac.repository.UserRepository;

/**
 * User Service
 * 
 * @author Rafael Rodrigues
 */

@Service
public class UserService {
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * Creates and saves a user
	 * 
	 * @param User signupUser
	 * @return Optional of user, empty if already exists
	 */
	public Optional<User> signup(User signupUser) {
		Optional<User> user = Optional.empty();
		if (!userRepository.findByEmail(signupUser.getEmail()).isPresent()
				&& !userRepository.findByCpf(signupUser.getCpf()).isPresent()) {
			user = Optional.of(userRepository.save(new User(signupUser.getFirstName(), signupUser.getLastName(),
					signupUser.getEmail(), signupUser.getCpf(), signupUser.getBirthDate())));
		}
		return user;
	}
}