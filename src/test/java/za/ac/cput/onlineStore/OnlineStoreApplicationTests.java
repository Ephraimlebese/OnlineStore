package za.ac.cput.onlineStore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.testng.annotations.Configuration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OnlineStoreApplication.class)
@WebAppConfiguration
@ComponentScan
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication


public class OnlineStoreApplicationTests {

	@Test
	public void contextLoads() {
	}

}
