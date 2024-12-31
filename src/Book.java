import java.time.LocalDate;

public class Book {

    private int id;
    private static int idCounter = 1;
    private String title;
    private Author author;
    private boolean isLoan = false;
    private LocalDate createAt = LocalDate.now();
    private LocalDate updateAt = LocalDate.now();

    public Book(String title, Author author) {
        id = idCounter++;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isLoan() {
        return isLoan;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public LocalDate getUpdateAt() {
        return updateAt;
    }

    public void loan() {
        isLoan = true;
        updateAt = LocalDate.now();
    }

    public void returned() {
        isLoan = false;
        updateAt = LocalDate.now();
    }


}
