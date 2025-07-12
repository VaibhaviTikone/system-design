import lombok.Data;

@Data
public class Seat {
    private String id;
    private String row;
    private double price;
    private SeatType seatType;
    private Status status;

    public enum Status {
        AVAILABLE, BOOKED
    }

    public enum SeatType {
        PREMIUM, GOLD, SILVER
    }
}
