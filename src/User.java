import java.time.LocalDate;

public class User {

    private int id;
    private static int idCounter = 1;
    private String name;
    private LocalDate birthday;

    public User(String name, LocalDate birthday) {
        id = idCounter++;
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

}
