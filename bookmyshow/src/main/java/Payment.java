import lombok.Data;

@Data
public class Payment {
    private String id;
    private String method;
    private double amount;
    private PaymentStatus paymentStatus;


    public enum PaymentStatus {
        SUCCESS, FAILURE, INPROGRESS
    }
}
