package com.sanidhya.book.service;

import com.sanidhya.book.model.Book;

import java.util.ArrayList;

public class BookService {

    ArrayList<Book> library = new ArrayList<>();

    public void addBook(String title,String author){
        Book book = new Book(author,title);
        library.add(book);
    }

    public void removeBook(int id){
        for(Book bk : library){
            if(bk.getId()==id) {
                library.remove(bk);
            }
        }
    }

    public Book searchByTitle(String title){
        for(Book bk : library){
            if(bk.getTitle().equals(title)) return bk;
        }
        return null;
    }

    public void displayAllBooks(){
        for(Book bk : library){
            System.out.println(bk.toString());
        }
    }

}
