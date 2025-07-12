import lombok.Data;

import java.util.List;
@Data
public class Theatre {
    private String id;
    private String name;
    private String location;
    private List<Show> showList;
    private List<Screen> screens;
    private List<Movies> movies;
}
