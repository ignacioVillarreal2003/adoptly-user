package iv.adoptlyuser.domain.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserCreateRequest(
        @NotNull
        UUID authId,

        @NotBlank @Email
        String email
) {}

