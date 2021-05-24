package io.orangehealth.bvac.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.orangehealth.bvac.domain.User;
import io.orangehealth.bvac.repository.UserRepository;
import io.orangehealth.bvac.web.RegisterUserDto;

/**
 * User Service
 * 
 * @author Rafael Rodrigues
 */

@Service
public class UserService {
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public RegisterUserDto signup(RegisterUserDto registerUserDto) {
		Optional<User> user = Optional.empty();
		if (!userRepository.findByEmail(registerUserDto.getEmail()).isPresent()
				&& !userRepository.findByCpf(registerUserDto.getCpf()).isPresent()) {
			user = Optional.of(userRepository.save(new User(registerUserDto.getFirstName(), registerUserDto.getLastName(),
					registerUserDto.getEmail(), registerUserDto.getCpf(), registerUserDto.getBirthDate())));
		} else {
			user.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"CPF or e-mail already registered."));
		}
		return registerUserDto;
	}

	public Optional<User> findById(long id) {
		return userRepository.findById(id);
	}
}