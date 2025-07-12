import lombok.Data;

import java.util.List;

@Data
public class Show {
    private String id;
    private long startTime;
    private long endTime;
    private Movies movies;
    private Screen screen;
    private List<Seat> seats;
}
