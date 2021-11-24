import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CityLibraryTests {

    CityLibrary cityLibrary = new CityLibrary();

    @Test
    public void addBookByCountTest(){
        cityLibrary = new CityLibrary();
        List<Book> booksList = cityLibrary.findAvailableBooks();
        int countOfBooksInLibrary = booksList.size();

        System.out.println("Count: " + countOfBooksInLibrary);
        Book book = new Book(1, "Tom Sawyer");
        cityLibrary.addNewBook(book);

        Assert.assertEquals(cityLibrary.findAvailableBooks().size(), countOfBooksInLibrary + 1, "Can't add book");
    }

    /**
     * Тестирование метода добавление книги путём поиска книги в списке книг
     */
    @Test
    public void addBookBySearchObjectInListTest(){
        cityLibrary = new CityLibrary();
        Book book = new Book(1, "Tom Sawyer");

        List<Book> booksList = cityLibrary.findAvailableBooks();
        boolean isFind = booksList.contains(book);
        cityLibrary.addNewBook(book);
        booksList = cityLibrary.findAvailableBooks();

        Assert.assertNotEquals(booksList.contains(book), isFind, "Can't add book");
    }

    /**
     * Тестирование взятия книги студентом, которая есть в библиотеке
     */
    @Test
    public void borrowBookTest(){
        String student = "Petro";
        Book book = new Book(1, "Tom Sawyer");
        cityLibrary = new CityLibrary();
        cityLibrary.addNewBook(book);
        int countOfBooksInLibrary = cityLibrary.findAvailableBooks().size();
        Assert.assertEquals(countOfBooksInLibrary, 1, "Book not added.");

        Book borrowedBook = cityLibrary.borrowBook(book, student);

        Assert.assertNotNull(borrowedBook, "Book not borrowed");
        Assert.assertEquals(cityLibrary.findAvailableBooks().size(), countOfBooksInLibrary - 1, "Book not removed from list of available books");
    }

    @Test
    public void returnBookTest(){
        // copypaste from borrowBookTest()
        String student = "Petro";
        Book book = new Book(1, "Tom Sawyer");
        cityLibrary = new CityLibrary();
        cityLibrary.addNewBook(book);
        int countOfBooksInLibrary = cityLibrary.findAvailableBooks().size();
        Assert.assertEquals(countOfBooksInLibrary, 1, "Book not added.");

        Book borrowedBook = cityLibrary.borrowBook(book, student);

        Assert.assertNotNull(borrowedBook, "Book not borrowed");
        Assert.assertEquals(cityLibrary.findAvailableBooks().size(), countOfBooksInLibrary - 1, "Book not removed from list of available books");

        cityLibrary.returnBook(book, student);
        Assert.assertEquals(cityLibrary.findAvailableBooks().size(), countOfBooksInLibrary, "Book not added to list of available books");
    }

}
