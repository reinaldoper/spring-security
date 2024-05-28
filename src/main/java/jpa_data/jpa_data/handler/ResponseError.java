package jpa_data.jpa_data.handler;
import java.util.Date;

@SuppressWarnings("serial")
public class ResponseError extends RuntimeException {
    private Date timestemp = new Date();

    public Date getTimestemp() {
        return timestemp;
    }

    public void setTimestemp(Date timestemp) {
        this.timestemp = timestemp;
    }
    public ResponseError(){
        super();
    }
}
