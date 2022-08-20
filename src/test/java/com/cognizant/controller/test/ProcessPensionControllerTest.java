package com.cognizant.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.controller.ProcessPensionController;
import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerInput;
import com.cognizant.restClient.AuthorizationClient;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
public class ProcessPensionControllerTest {

	@Mock
	ProcessPensionController processpensioncontroller;

	@Autowired
	private MockMvc mvc;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	ObjectMapper objectMapper = new ObjectMapper();
	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNTcyMTkxMywiaWF0IjoxNjE1NTQxOTEzfQ.sBh1dxvrhBUQWtmOIzJ0HYBIQCxZ__5Hhr1IvsOyYNI";

	@Test
	public void contextLoads() {
		assertNotNull(processpensioncontroller);
	}
	
	
	@Test
	public void allDetailTest() {	
		assertNotNull(processpensioncontroller.allDetail());
	}
	
	@Test
	public void getPensionDetail() throws Exception {
		PensionerInput pensionerInput = new PensionerInput("Prasanna", "03-03-2000","PASW33334DW","1234567890","family");
		PensionDetail pensionDetail = new PensionDetail("Prasanna","03-03-2000","PASW33334DW","family",30105);
		when(processpensioncontroller.getPensionDetail(token, pensionerInput)).thenReturn(pensionDetail);		
		assertEquals(processpensioncontroller.getPensionDetail(token, pensionerInput),pensionDetail);
	}
	
}
	
	