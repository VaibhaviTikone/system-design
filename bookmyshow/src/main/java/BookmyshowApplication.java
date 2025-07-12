import java.awt.print.Book;
import java.util.ArrayList;

public class BookmyshowApplication {
    public static void main(String[] args) {
        System.out.println("Application started");
        Movies movies = new Movies();
        movies.setTitle("abc");
        movies.setDuration(2);
        Show show = new Show();
        show.setId("1");
        show.setMovies(movies);
        show.setStartTime(12);
        show.setEndTime(3);

        Booking booking = new Booking();
        booking.setId("01");
        booking.setSeatList(new ArrayList<>());
    }
}
