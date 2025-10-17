package iv.adoptlyuser.application.services.preference;

import java.util.UUID;

public interface PreferenceDeletionService {
    void permanentlyDelete(UUID preferenceId);
}
