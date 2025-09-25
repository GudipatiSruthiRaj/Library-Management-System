import java.util.ArrayList;
import java.util.Scanner;
//BookClass
class Book{
    private String title;
    private String author;
    private boolean isIssued;
    public Book(String title,String author){
        this.title=title;
        this.author=author;
        this.isIssued=false;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public boolean isIssued(){
        return isIssued;
    }
    public void issue(){
        isIssued=true;
    }
    public void returnBook(){
        isIssued=false;
    }
    public String toString(){
        return title+"by"+author+(isIssued? "(Issued)":"(Availble)");
        
    }
}
//user class
class User{
    private String name;
    private int userId;
    public User(String name,int userId){
        this.name=name;
        this.userId=userId;
    }
    public String getName(){
        return name;
    }
    public int userId(){
        return userId;
    }
    public String toString(){
        return "User: "+name+" (ID: "+userId+")";
    }
}
//library class
class library{
    private ArrayList<Book>books=new ArrayList<>();
    public void addBook(Book book){
        books.add(book);
        System.out.println("Book Added:"+book.getTitle());
    }
    public void showbooks(){
        System.out.println("..Availble Books:");
        for(Book book:books){
            System.out.println(book);

        }
    }
    public void issueBook(String title){
        for(Book book:books){
            if(book.getTitle().equalsIgnoreCase(title)&&!book.isIssued()){
                book.issue();
                System.out.println("Bookissued:"+title);
                return;
            }
        }
        System.out.println("Book not availble for issue");

    }
    public void returnBook(String title){
        for(Book book:books){
            if (book.getTitle().equalsIgnoreCase(title) && book.isIssued()) {
                book.returnBook();
                System.out.println("Book returned:"+title);
                return;
        }
    }
    System.out.println("Book not found and Not issued");
}
}
//main class
public class Main {
    public static void main(String[] args) {
        library library = new library();
        Scanner sc = new Scanner(System.in);

        // Sample Books
        library.addBook(new Book("Java Basics", "James Gosling"));
        library.addBook(new Book("Python Crash Course", "Eric Matthes"));
        library.addBook(new Book("C++ Primer", "Stanley Lippman"));

        int choice;
        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Show Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.showbooks();
                    break;
                case 2:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    library.issueBook(issueTitle);
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}