package LibraryManagementSystem;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn))
                return book;
        }
        return null;
    }

    public Member findMemberById(String id) {
        for (Member m : members) {
            if (m.getMemberId().equals(id))
                return m;
        }
        return null;
    }

    public void displayAllBooks() {
        System.out.println("\n=== ALL BOOKS ===");
        for (Book book : books) {
            book.display();
        }
    }

    public void displayAvailableBooks() {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        boolean found = false;
        for (Book book : books) {
            if (book.isAvailable()) {
                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books available!");
        }
    }

    public void searchBooks(String keyword) {
        System.out.println("\nSearch Results:");
        boolean found = false;
        keyword = keyword.toLowerCase();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword) ||
                book.getAuthor().toLowerCase().contains(keyword) ||
                book.getGenre().toLowerCase().contains(keyword)) {

                book.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching books found!");
        }
    }
}

