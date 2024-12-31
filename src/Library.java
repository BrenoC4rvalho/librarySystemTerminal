import java.util.ArrayList;
import java.util.List;

public class Library {

    private String name;
    private List<Book> books;
    private List<Author> authors;
    private List<Loan> loans;

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getAvailableBooks() {
        List<Book> availablebooks = new ArrayList<>();
        for(Book book : books) {
            if(!book.isLoan()) {
                availablebooks.add(book);
            }
        }
        return availablebooks;
    }

    public Book getBookById(int id) {
        for(Book book : books) {
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }



    public void addBook(Book book) {
        books.add(book);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
    }
}

