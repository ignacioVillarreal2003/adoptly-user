package iv.adoptlyuser.application.exceptions.conflict;

import iv.adoptlyuser.application.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public abstract class ConflictException extends ApiException {
    public ConflictException(String message, String code) {
        super(HttpStatus.NOT_FOUND, code, message);
    }
}
