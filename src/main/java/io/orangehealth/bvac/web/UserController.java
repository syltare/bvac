package io.orangehealth.bvac.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.orangehealth.bvac.domain.User;
import io.orangehealth.bvac.service.UserService;

/**
 * User Controller
 * 
 * @author Rafael Rodrigues
 */

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
	 * Signup Endpoint
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(path = "/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public User singup(@Valid @RequestBody User user) {
		return userService.signup(user)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"CPF or e-mail already registered."));
	}
}