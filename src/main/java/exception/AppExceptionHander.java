package exception;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class AppExceptionHander extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<Object> handlerRequestException(RequestException ex, WebRequest request){
        return handleExption(ex, ex.getErrorCode(), ex.getMessage(), HttpStatus.BAD_REQUEST, request);
    }

   @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handlerGenericException(Exception ex, WebRequest request) {

       return handleExption(ex,null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private ResponseEntity<Object> handleExption(
            Exception ex,
            String errorCode,
            String message,
            HttpStatus status,
            WebRequest request
    ){

        ServletWebRequest servletWebRequest = (ServletWebRequest) request;


        return handleExceptionInternal(
                ex, RestError.builder()
                        .errorCode(errorCode)
                        .errorCodeMessage(message)
                        .status(String.valueOf(status.value()))
                        .path(servletWebRequest.getRequest().getRequestURI())
                        .build(),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request
        );
    }

}