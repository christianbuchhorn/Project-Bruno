package exception;

import lombok.Data;
import lombok.Builder;
import java.util.List;

@Data
@Builder
public class RestError {
    private final String errorCode;
    private final String errorCodeMessage;
    private final List<String> details;
    private final String status;
    private final String path;
}