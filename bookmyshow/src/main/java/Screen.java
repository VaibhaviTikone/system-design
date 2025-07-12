import lombok.Data;

import java.util.List;
@Data
public class Screen {
    private String id;
    private int number;
    private List<Show> showList;
    private ScreenType screenType;


    public enum ScreenType {
        S2D, S3D, S4D
    }
}
