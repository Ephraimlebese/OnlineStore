package za.ac.cput.onlineStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication
public class OnlineStoreApplication {

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(OnlineStoreApplication.class, args);
    }
}
