package iv.adoptlyuser.application.exceptions.unauthorized;

public class InvalidAuthenticationException extends UnauthorizedException {
    public InvalidAuthenticationException() {
        super(
                "INVALID_AUTHENTICATION",
                "Invalid authentication."
        );
    }
}
