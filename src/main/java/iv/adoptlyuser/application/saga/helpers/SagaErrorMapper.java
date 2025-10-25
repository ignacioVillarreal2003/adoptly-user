package iv.adoptlyuser.application.saga.helpers;

import iv.adoptlyuser.application.exceptions.notFound.SagaNotFoundException;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

public class SagaErrorMapper {

    public record SagaError(Integer code, String message) {}

    public static SagaError map(Throwable ex) {
        if (ex instanceof SagaNotFoundException) {
            return new SagaError(404, ex.getMessage());
        }
        if (ex instanceof ResponseStatusException rse) {
            return new SagaError(rse.getStatusCode().value(), rse.getReason());
        }
        if (ex.getCause() instanceof MethodArgumentNotValidException validationEx) {
            String errors = validationEx.getBindingResult()
                    .getFieldErrors()
                    .stream()
                    .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                    .collect(Collectors.joining("; "));
            return new SagaError(400, errors);
        }
        return new SagaError(500, ex.getMessage());
    }
}
