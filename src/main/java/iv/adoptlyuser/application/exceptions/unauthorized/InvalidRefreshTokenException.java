package iv.adoptlyuser.application.exceptions.unauthorized;

public class InvalidRefreshTokenException extends UnauthorizedException {
    public InvalidRefreshTokenException() {
        super(
                "INVALID_CREDENTIALS",
                "Invalid refresh token."
        );
    }
}
