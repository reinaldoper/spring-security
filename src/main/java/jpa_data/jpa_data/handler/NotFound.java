package jpa_data.jpa_data.handler;

@SuppressWarnings("serial")
public class NotFound  extends RuntimeException{
    public NotFound(){
        super("Not found.");
    }
}
