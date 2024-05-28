package jpa_data.jpa_data.handler;

@SuppressWarnings("serial")
public class ResponseAddUserError extends RuntimeException {
    public ResponseAddUserError(){
        super("Faltam dados no corpo da requisição.");
    }
}
