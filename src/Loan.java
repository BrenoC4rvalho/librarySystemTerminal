import java.time.LocalDate;

public class Loan {

    private int id;
    private static int idCounter = 0;
    private Book book;
    private User user;
    private LocalDate loanAt = LocalDate.now();
    private LocalDate returnDate;
    private boolean isActive = true;

    public Loan(Book book, User user, LocalDate returnDate) {
        id = idCounter++;
        this.book = book;
        this.user = user;
        this.returnDate = returnDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getLoanAt() {
        return loanAt;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setIsActivate() {
        isActive = !isActive;
    }
}
