package iv.adoptlyuser.api.controllers;

import iv.adoptlyuser.application.services.user.*;
import iv.adoptlyuser.domain.dtos.user.UserPrivateResponse;
import iv.adoptlyuser.domain.dtos.user.UserPublicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private UserRetrieveService userRetrieveService;

    @GetMapping("/public/{email}")
    public ResponseEntity<UserPublicResponse> getUserPublic(@PathVariable String email) {
        UserPublicResponse response = userRetrieveService.getUserPublic(email);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/private/{email}")
    public ResponseEntity<UserPrivateResponse> getUserPrivate(@PathVariable String email) {
        UserPrivateResponse response = userRetrieveService.getUserPrivate(email);
        return ResponseEntity.ok(response);
    }
}
