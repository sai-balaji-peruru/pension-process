package com.cognizant.service.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.model.BankDetail;
import com.cognizant.model.PensionDetail;
import com.cognizant.model.PensionerDetail;
import com.cognizant.model.PensionerInput;
import com.cognizant.repository.PensionDetailRepository;
import com.cognizant.service.ProcessPensionService;

@SpringBootTest
public class ProcessPensionServiceTest {

	@Mock
	ProcessPensionService processPensionService;
	
	@Mock
	PensionDetailRepository pensionDetailRepository;
	
	@Test
	public void testNotNullPensionDetailService() {
		assertNotNull(processPensionService);
	}
	
	
	
	@Test
	public void getPensionDetailTest() {
		
		BankDetail bankDetail = new BankDetail("ICICI", "12345678", "private");
		PensionerDetail pensionerDetail = new PensionerDetail("982897132579", "Prasanna", "03-03-2000", "PCASD1234Q",27000, 10000, "self", bankDetail);
		PensionerInput pensionerInput = new PensionerInput("Prasanna", "03-03-2000","PCASD1234Q","982897132579","self");
		PensionDetail pensionDetail = new PensionDetail("Prasanna","03-03-2000","PCASD1234Q","self",31050);
		when(processPensionService.getPensionDetail(pensionerDetail, pensionerInput)).thenReturn(pensionDetail);
		assertEquals(processPensionService.getPensionDetail(pensionerDetail, pensionerInput),pensionDetail);
	}
	
	
	
	
	
}