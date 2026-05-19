package exception;
import exception.RestError;
import jakarta.servlet.Servlet;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityReturnValueHandler;

@ControllerAdvice
public class AppExceptionHander extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handlerGenericException(Exception ex, WebRequest request) {

        ServletWebRequest servletWebRequest = (ServletWebRequest) request;

        return handleExceptionInternal(ex, RestError.builder().errorCode("xyz").errorCodeMessage(ex.getMessage())
                        .status(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                        .path(servletWebRequest.getRequest().getRequestURI())
                        .build(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
