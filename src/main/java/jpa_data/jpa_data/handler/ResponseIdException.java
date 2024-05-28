package jpa_data.jpa_data.handler;

@SuppressWarnings("serial")
public class ResponseIdException extends RuntimeException {
    public ResponseIdException(){
        super("O Id não pode ser nulo.");
    }
}
