package iv.adoptlyuser.configuration;

import iv.adoptlyuser.configuration.authentication.AuthenticationUserProvider;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component("auditorAware")
@RequiredArgsConstructor
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditorAwareImpl implements AuditorAware<String> {

    private final AuthenticationUserProvider authenticationUserProvider;

    @Override
    public @NotNull Optional<String> getCurrentAuditor() {
        UUID authId = authenticationUserProvider.getAuthId();
        if (authId != null) {
            return Optional.of(authId.toString());
        }
        return Optional.of("system");
    }
}