package LibraryManagementSystem;
import java.util.Scanner;

public class LibrarySystem {

    private static Scanner sc = new Scanner(System.in);
    private static Library library = new Library();

    public static void main(String[] args) {

        // Pre-register a member for testing
        library.addMember(new Member("M001", "Alice Johnson", "9876543210"));

        while (true) {
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. Add New Book");
            System.out.println("2. Register New Member");
            System.out.println("3. Display All Books");
            System.out.println("4. Display Available Books");
            System.out.println("5. Search Books");
            System.out.println("6. Borrow Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> addMember();
                case 3 -> library.displayAllBooks();
                case 4 -> library.displayAvailableBooks();
                case 5 -> searchBooks();
                case 6 -> borrowBook();
                case 7 -> returnBook();
                case 8 -> {
                    System.out.println("Thank you for using Library Management System!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void addBook() {
        System.out.println("\n=== ADD NEW BOOK ===");
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Genre: ");
        String genre = sc.nextLine();

        library.addBook(new Book(isbn, title, author, genre));
        System.out.println(" Book added successfully!");
    }

    private static void addMember() {
        System.out.print("Member ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Contact: ");
        String contact = sc.nextLine();

        library.addMember(new Member(id, name, contact));
        System.out.println(" Member registered successfully!");
    }

    private static void searchBooks() {
        System.out.println("\n=== SEARCH BOOKS ===");
        System.out.print("Enter search keyword: ");
        String key = sc.nextLine();
        library.searchBooks(key);
    }

    private static void borrowBook() {
        System.out.println("\n=== BORROW BOOK ===");
        System.out.print("Enter Member ID: ");
        String memberId = sc.nextLine();
        System.out.print("Enter Book ISBN: ");
        String isbn = sc.nextLine();

        Member member = library.findMemberById(memberId);
        Book book = library.findBookByIsbn(isbn);

        if (member != null && book != null && member.borrowBook(book)) {
            System.out.println(" Book borrowed successfully!");
            System.out.println("Member: " + member.getName());
            System.out.println("Book: " + book.getTitle());
            System.out.println("Due Date: 2024-02-15");
        } else {
            System.out.println(" Book not available or invalid details!");
        }
    }

    private static void returnBook() {
        System.out.println("\n=== RETURN BOOK ===");
        System.out.print("Enter Member ID: ");
        String memberId = sc.nextLine();
        System.out.print("Enter Book ISBN: ");
        String isbn = sc.nextLine();

        Member member = library.findMemberById(memberId);
        Book book = library.findBookByIsbn(isbn);

        if (member != null && book != null && member.returnBook(book)) {
            System.out.println(" Book returned successfully!");
        } else {
            System.out.println("Return failed!");
        }
    }
}
