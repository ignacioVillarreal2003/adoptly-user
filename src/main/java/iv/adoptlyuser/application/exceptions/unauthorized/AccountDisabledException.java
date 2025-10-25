package iv.adoptlyuser.application.exceptions.unauthorized;

public class AccountDisabledException extends UnauthorizedException {
    public AccountDisabledException() {
        super(
                "ACCOUNT_DISABLED",
                "Account disabled."
        );
    }
}