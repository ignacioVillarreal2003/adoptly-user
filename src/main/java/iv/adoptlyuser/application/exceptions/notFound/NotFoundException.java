package iv.adoptlyuser.application.exceptions.notFound;

import iv.adoptlyuser.application.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public abstract class NotFoundException extends ApiException {
    public NotFoundException(String message, String code) {
        super(HttpStatus.NOT_FOUND, code, message);
    }
}