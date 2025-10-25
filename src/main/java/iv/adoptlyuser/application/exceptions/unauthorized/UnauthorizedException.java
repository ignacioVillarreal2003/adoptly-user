package iv.adoptlyuser.application.exceptions.unauthorized;

import iv.adoptlyuser.application.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public abstract class UnauthorizedException extends ApiException {
  public UnauthorizedException(String message, String code) {
    super(HttpStatus.UNAUTHORIZED, code, message);
  }
}
