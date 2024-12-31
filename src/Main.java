import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library("MyLibrary");

        Author nicolelis = new Author("Miguel Nicolelis", LocalDate.of(1961, 3, 7));
        Author lembke = new Author("Anna Lembke", LocalDate.of(1967, 11, 27));
        Author huberman = new Author("Andrew Huberman", LocalDate.of(1975, 9, 26));

        library.addAuthor(nicolelis);
        library.addAuthor(lembke);
        library.addAuthor(huberman);

        Book macaiba = new Book("Made in Macaíba", nicolelis);
        Book creator = new Book("The true creator of everything", nicolelis);
        Book brain = new Book("The Relativistic Brain", nicolelis);
        Book drug = new Book("Drug Dealer, MD", lembke);
        Book dopamine = new Book("The Official Dopamine Nation", lembke);
        Book protocols = new Book("Protocols", huberman);

        library.addBook(macaiba);
        library.addBook(creator);
        library.addBook(brain);
        library.addBook(drug);
        library.addBook(dopamine);
        library.addBook(protocols);

        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while(flag) {
            System.out.println("Do you see a book available? [yes/no] ");
            String response = scanner.nextLine().toLowerCase();

            if(response.equals("yes")) {

                List<Book> avaliableBooks = library.getAvailableBooks();

                if(avaliableBooks.isEmpty()) {
                    System.out.println("Don't have avaliables book in moment");
                    break;
                }

                System.out.println("Avaliables books");
                for(Book book: avaliableBooks) {
                    System.out.println(book.getId() + " : " + book.getTitle());
                }

                System.out.println("Enter the ID of the book you want to borrow:");
                int bookId = scanner.nextInt();
                scanner.nextLine();

                Book selectedBook = library.getBookById(bookId);

                if(selectedBook != null && !selectedBook.isLoan()) {
                    System.out.println("What's your name?");
                    String name = scanner.nextLine();
                    System.out.println("What year were you born?");
                    int birthYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("What month were you born?");
                    int birthMonth = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("What day were you born?");
                    int birthDay = scanner.nextInt();
                    scanner.nextLine();

                    User user = new User(name, LocalDate.of(birthYear, birthMonth, birthDay));
                    Loan loan = new Loan(selectedBook, user, LocalDate.now().plusDays(15));
                    selectedBook.loan();
                    library.addLoan(loan);
                    System.out.println("The book" + selectedBook.getTitle() + "was lent to" + user.getName() );
                } else {
                    System.out.println("The book not found or no avaliables");
                }

            } else if(response.equals("no")) {
                System.out.println("Thank very much you for using the library system.");
                flag = false;
            } else {
                System.out.println("Invalid response. Please answer yes or no.");
            }
        }

        scanner.close();

    }
}