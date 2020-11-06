package com.kaizimmerm.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

		mvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.message").value("Hello World!"));
	}

	@Test
	public void paramGreetingShouldReturnTailoredMessage() throws Exception {

		mvc.perform(get("/hello").param("name", "Cloud Developer")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.message").value("Hello Cloud Developer!"));
	}

}
