package iv.adoptlyuser.application.exceptions.forbidden;

import iv.adoptlyuser.application.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public abstract class ForbiddenException extends ApiException {
    public ForbiddenException(String message, String code) {
        super(HttpStatus.FORBIDDEN, code, message);
    }
}
