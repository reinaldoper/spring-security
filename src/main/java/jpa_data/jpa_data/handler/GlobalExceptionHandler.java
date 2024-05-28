package jpa_data.jpa_data.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseAddUserError.class)
    public ResponseEntity<Object> handleResponseAddUserError(ResponseAddUserError ex) {
        Map<String, String> responseentity = new HashMap<>();
        responseentity.put("message", ex.getMessage());
        return new ResponseEntity<>(responseentity, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<Object> handleNotFound(NotFound ex) {
        Map<String, String> responseentity = new HashMap<>();
        responseentity.put("message", ex.getMessage());
        return new ResponseEntity<>(responseentity, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResponseIdException.class)
    public ResponseEntity<Object> hadleIdIsnumeric(ResponseIdException ex){
        Map<String, String> responseentity = new HashMap<>();
        responseentity.put("message", ex.getMessage());
        return new ResponseEntity<>(responseentity, HttpStatus.BAD_REQUEST);
    }

}
