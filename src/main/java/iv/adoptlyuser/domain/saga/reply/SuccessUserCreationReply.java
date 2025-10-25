package iv.adoptlyuser.domain.saga.reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuccessUserCreationReply implements Serializable {
    private UUID sagaId;
}