package com.Task3;
public class Library {
    private Book[] books;
    private int size;

    public Library(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size == books.length) {
            resizeArray();
        }
        books[size++] = book;
    }

    private void resizeArray() {
        Book[] newBooks = new Book[books.length * 2];
        for (int i = 0; i < books.length; i++) {
            newBooks[i] = books[i];
        }
        books = newBooks;
    }

    public void removeBook(int bookID) {
        for (int i = 0; i < size; i++) {
            if (books[i].getBookID() == bookID) {
                books[i] = books[size - 1];
                books[size - 1] = null;
                size--;
                break;
            }
        }
    }

    public Book searchBook(int bookID) {
        for (int i = 0; i < size; i++) {
            if (books[i].getBookID() == bookID) {
                return books[i];
            }
        }
        return null;
    }

    public void displayBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }
}
