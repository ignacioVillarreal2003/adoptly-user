package iv.adoptlyuser.application.exceptions.unauthorized;

public class UserAlreadyEnabledException extends UnauthorizedException {
    public UserAlreadyEnabledException() {
        super(
                "USER_ALREADY_ENABLED",
                "User is already enabled."
        );
    }
}
