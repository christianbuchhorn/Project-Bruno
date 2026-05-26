package exception;
import lombok.Getter;

@Getter

public class RequestExcepition extends RuntimeException {
    private final String errorCode;

    public RequestExcepition(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }

}
