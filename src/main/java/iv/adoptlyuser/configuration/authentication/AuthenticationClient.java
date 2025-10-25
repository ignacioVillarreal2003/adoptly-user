package iv.adoptlyuser.configuration.authentication;

import iv.adoptlyuser.domain.dtos.AuthenticationUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authentication-service", url = "${clients.authentication-service-url}")
public interface AuthenticationClient {

    @PostMapping("/verify")
    AuthenticationUser verifyToken(@RequestHeader("Authorization") String authenticationHeader);
}
