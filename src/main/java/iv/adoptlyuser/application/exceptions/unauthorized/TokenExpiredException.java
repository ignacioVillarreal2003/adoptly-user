package iv.adoptlyuser.application.exceptions.unauthorized;

public class TokenExpiredException extends UnauthorizedException {
    public TokenExpiredException() {
        super(
                "TOKEN_EXPIRED",
                "Token is expired."
        );
    }
}
