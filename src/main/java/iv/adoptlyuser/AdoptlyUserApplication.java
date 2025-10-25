package iv.adoptlyuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AdoptlyUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdoptlyUserApplication.class, args);
    }

}
