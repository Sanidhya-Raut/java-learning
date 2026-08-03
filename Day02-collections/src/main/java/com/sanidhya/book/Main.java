package com.sanidhya.book;

import com.sanidhya.book.model.Book;
import com.sanidhya.book.service.BookService;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();

        bookService.addBook("HarryPotter","J K Rowling");
        bookService.addBook("Moby-Dick","Herman Melville");
        bookService.addBook("Pride and Prejudice","Jane Austen");
        bookService.addBook("1984","George Orwell");
        bookService.addBook("To Kill a Mockingbird","Harper Lee");

        Book bk = bookService.searchByTitle("1984");
        if(bk != null)
            bookService.removeBook(bk.getId());

        bookService.displayAllBooks();
    }
}
