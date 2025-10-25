package iv.adoptlyuser.application.exceptions.unauthorized;

public class AccountCredentialsExpiredException extends UnauthorizedException {
    public AccountCredentialsExpiredException() {
        super(
                "ACCOUNT_CREDENTIALS_EXPIRED",
                "Account credentials expired."
        );
    }
}
