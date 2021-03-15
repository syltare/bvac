package io.orangehealth.bvac.web;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import io.orangehealth.bvac.domain.User;
import io.orangehealth.bvac.service.UserService;

/**
 * User Controller tests
 * 
 * @author Rafael Rodrigues
 */
@WebMvcTest(UserController.class)
class UserControllerTest {

	private Optional<User> testUser = Optional
			.of(new User("Malcolm", "X", "malcolmx@email.com", "000.000.000-00", LocalDate.of(1925, 05, 19)));
	private String jsonContent = "{\"firstName\": \"Malcolm\","
								+ "\"lastName\": \"X\","
								+ "\"email\": \"malcolmx@email.com\","
								+ "\"cpf\": \"000.000.000-00\","
								+ "\"birthDate\": \"1925-05-19\"}";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Test
	void testSingupHappyPath() throws Exception {
		Mockito.when(userService.signup(ArgumentMatchers.any(User.class))).thenReturn(testUser);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/users/signup")
				.content(jsonContent)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated());				
	}
	
	@Test
	void testSignupUnhappyPath() throws Exception {
		Mockito.when(userService.signup(testUser.get())).thenReturn(testUser);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/users/signup")
				.content(jsonContent)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
