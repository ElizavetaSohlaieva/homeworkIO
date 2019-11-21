package com.epam.hw8;

import java.util.Arrays;
import java.util.Comparator;

public class Books {
    public Book[] bookArray;
    private int counter = 0;

    public Books(int size) {
        bookArray = new Book[size];
    }

    public void addBooks(Book newBook){
        if (counter < bookArray.length) {
            bookArray[counter++] = newBook;
        }
    }

    public void viewAllBooks() {
        if (counter == 0) {
            System.out.println("No books");
            return;
        }
        for (int i = 0; i < counter; i++) {
            System.out.println(bookArray[i]);
        }
    }

    public void changePrice(double proc) {
        double newPrice = 0;
        for (int i = 0; i < counter; i++) {
            newPrice = bookArray[i].getPrice()
                    + bookArray[i].getPrice() * proc / 100;
            bookArray[i].setPrice(newPrice);
        }
    }

    public Books searchAuthor(String searchText) {
        Books newBooks = new Books(counter);
        for (int i = 0; i < counter; i++) {
            if (bookArray[i].getAuthor().equalsIgnoreCase(searchText)) {
                newBooks.addBooks(bookArray[i]);
            }
        }
        return newBooks;
    }

    public Books searchYear(int finderYear){
        Books newBooks = new Books(counter);
        for (int i = 0; i < counter; i++) {
            if (bookArray[i].getYear() > finderYear){
                newBooks.addBooks(bookArray[i]);
            }
        }
        return newBooks;
    }

    public void sortByAuthor() {
        Book[] sortedBook = Arrays.copyOf(bookArray, counter);
        Arrays.sort(sortedBook, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getAuthor().compareTo(book2.getAuthor());
            }
        });
        System.arraycopy(sortedBook, 0, bookArray, 0, counter);
    }

    public void sortByEdition(){
        Book[] sortedBook = Arrays.copyOf(bookArray, counter);
        Arrays.sort(sortedBook, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.getEdition().compareTo(book2.getEdition());
            }
        });
        System.arraycopy(sortedBook, 0, bookArray, 0, counter);
    }

    public void sortByPrice(){
        Book[] sortedBook = Arrays.copyOf(bookArray, counter);
        Arrays.sort(sortedBook, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return Double.compare(book1.getPrice(), book2.getPrice());
            }
        });
        System.arraycopy(sortedBook, 0, bookArray, 0, counter);
    }
}
