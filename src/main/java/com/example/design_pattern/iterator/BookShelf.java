package com.example.design_pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements Aggregate {
    private List<Book> books;   
    public BookShelf(int initialsize) {         
        this.books = new ArrayList<>(initialsize);   
    }                                           
    public Book getBookAt(int index) {
        return books.get(index);          
    }
    public void appendBook(Book book) {
        books.add(book);                        
    }
    public int getLength() {
        return books.size();                    
    }
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
