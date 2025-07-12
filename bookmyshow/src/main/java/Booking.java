import lombok.Data;

import java.util.List;

@Data
public class Booking {
    private String id;
    private Payment payment;
    private User user;
    private List<Seat> seatList;
    private Show show;
}
