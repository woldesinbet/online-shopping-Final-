package resources.templates;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.project.warehouseCalls.SKUCreationRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiCallsTest {
	@Value("SKU_CREATION_REQUEST_PATH")
	private String SKU_CREATION_REQUEST_PATH;

	@Test
	public void test() {
		RestTemplate restTemplate = new RestTemplate();
		SKUCreationRequest cRequest = new SKUCreationRequest(1l, "name", BigDecimal.valueOf(123), "desc", 14);
		ResponseEntity<SKUCreationRequest> rRequest = restTemplate.postForEntity(this.SKU_CREATION_REQUEST_PATH,
				cRequest, SKUCreationRequest.class);
		assertNotNull(rRequest);
	}

}
