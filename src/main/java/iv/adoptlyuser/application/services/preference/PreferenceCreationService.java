package iv.adoptlyuser.application.services.preference;

import iv.adoptlyuser.domain.dtos.preference.PreferencePrivateResponse;

import java.util.UUID;

public interface PreferenceCreationService {
    PreferencePrivateResponse create(UUID userId);
}
