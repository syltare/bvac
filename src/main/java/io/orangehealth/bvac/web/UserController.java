package io.orangehealth.bvac.web;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.orangehealth.bvac.service.UserService;

/**
 * User Controller
 * 
 * @author Rafael Rodrigues
 */

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Signup Endpoint
	 * 
	 * @param RegisterUserDto object
	 * @return HTTP status 201 if success, HTTP 400 if fails
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RegisterUserDto singup(@Valid @RequestBody RegisterUserDto registerUserDto) {
		return userService.signup(registerUserDto);
	}
}