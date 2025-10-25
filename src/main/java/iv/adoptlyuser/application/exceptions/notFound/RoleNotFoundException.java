package iv.adoptlyuser.application.exceptions.notFound;

public class RoleNotFoundException extends NotFoundException {
    public RoleNotFoundException() {
        super(
                "ROLE_NOT_FOUND",
                "Role not found."
        );
    }
}