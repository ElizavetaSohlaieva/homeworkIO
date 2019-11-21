package com.epam.hw8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Books library = new Books(12);
        library.addBooks(new Book(1, "Alice in Wonderland", "Carroll", "Wordsworth", 2018, 160, 202.3));
        library.addBooks(new Book(2, "The Lord of the Rings", "Tolkien", "Hasper", 2014, 1358, 1950.5));
        library.addBooks(new Book(3, "Tom Sawyer", "Mark Twain", "Belford", 1976, 342, 125.5));
        library.addBooks(new Book(4, "The Hobbit", "Tolkien", "Hasper", 1937, 390, 320));
        library.addBooks(new Book(5, "Harry Potter", "J. Rolling", "Bloomsbury", 2014, 332, 415.8));
        library.addBooks(new Book(6, "The Great Gatsby", "F. Scott Fitzgerald", "Wordsworth", 1992, 144, 78.2));
        library.addBooks(new Book(7, "The War Prayer", "Mark Twain", "Wordsworth", 1961, 149, 79.8));
        library.addBooks(new Book(8, "Through the Looking-Glass", "Carroll", "Fingerprint", 2019, 156, 148.2));
        library.addBooks(new Book(9, "The Peoples of Middle-earth", "Tolkien", "Hasper", 2010, 512, 345.2));

        library.viewAllBooks();
        library.sortByAuthor();
        System.out.println("Sort By Author: ");
        library.viewAllBooks();
        System.out.println("Sort By Edition: ");
        library.sortByEdition();
        library.viewAllBooks();
        System.out.println("Sort By Price: ");
        library.sortByPrice();
        library.viewAllBooks();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter discount: ");

        double proc1 = 0.0;
        while (true) {
            proc1 = sc.nextDouble();
            try {
                Validator.validPrice(proc1);
                break;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Please, enter number more than 0");
            }
        }
        library.changePrice(proc1);
        library.viewAllBooks();

        System.out.println("Search author: ");
        String searchTxt;
        while (true){
            searchTxt = sc.nextLine();
            try {
                Validator.validAuthor(searchTxt);
                break;
            }catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Please, enter author");
            }
        }

        Books authors = library.searchAuthor(searchTxt);
        authors.viewAllBooks();

        System.out.println("Search year: ");
        int searchYears;
        while (true) {
            searchYears = sc.nextInt();
            try {
                Validator.validYear(searchYears);
                break;
            } catch (InvalidYearException e) {
                System.out.println(e.getMessage());
                System.out.println("Please, enter year from 1548 to 2019");
            }
        }
        Books libraryYears = library.searchYear(searchYears);
        libraryYears.viewAllBooks();
        ReadingAndSave readAndSave = new ReadingAndSave();
        readAndSave.readingFile();
        System.out.println("Add new book -> ");
        readAndSave.writingFile();
    }
}
