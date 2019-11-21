package com.epam.hw8;

public class Validator {
    public static void validYear(int newYear) {
        if (newYear < 1548 || newYear > 2019)
            throw new InvalidYearException("Invalid year");
    }

    public static void validAuthor(String newAuthor) {
        if (newAuthor.isEmpty()){
            throw new RuntimeException("Invalid author");
        }

    }
    public static void validPrice(double newPrice) {
        if (newPrice <= 0) {
            throw new RuntimeException("Number less than 0 ");
        }
    }
}
