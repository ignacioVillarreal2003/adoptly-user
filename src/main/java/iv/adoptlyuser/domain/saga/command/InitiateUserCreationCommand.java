package iv.adoptlyuser.domain.saga.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record InitiateUserCreationCommand(
        @NotNull()
        UUID sagaId,

        @NotNull
        UUID authId,

        @NotBlank() @Email() @Size(max = 100)
        String email
) {
}
