import lombok.Data;

import java.util.List;

@Data
public class User {
    private String id;
    private String name;
    private String pass;
    private long phoneNumber;
    private List<Booking> bookingList;

}
