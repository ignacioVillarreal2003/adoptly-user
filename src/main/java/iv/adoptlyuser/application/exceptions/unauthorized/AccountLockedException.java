package iv.adoptlyuser.application.exceptions.unauthorized;

public class AccountLockedException extends UnauthorizedException {
    public AccountLockedException() {
        super(
                "ACCOUNT_LOCKED",
                "Account locked."
        );
    }
}
