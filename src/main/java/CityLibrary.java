import java.util.*;

public class CityLibrary implements Library {
    private List<Book> bookList = new ArrayList<>();
    private Map<String, List<Book>> takenBooks = new HashMap<>();

    @Override
    public void addNewBook(Book book) {
        bookList.add(book);
    }

    @Override
    public Book borrowBook(Book book, String student) {
        if ( bookList.contains(book) ) {
            List<Book> takenBooksOfStudent;
            takenBooksOfStudent = ( takenBooks.get(student)!=null ) ? takenBooks.get(student) : new ArrayList<>();
            takenBooksOfStudent.add(book);
            takenBooks.put(student, takenBooksOfStudent);

            bookList.remove(book);

            return book;
        } else
            return null;
    }

    @Override
    public void returnBook(Book book, String student) {
        List<Book> takenBooksOfStudent = takenBooks.get(student);
        takenBooksOfStudent.remove(book);
        takenBooks.put(student, takenBooksOfStudent);

        bookList.add(book);
    }

    @Override
    public List<Book> findAvailableBooks() {
        return bookList;
    }

}
