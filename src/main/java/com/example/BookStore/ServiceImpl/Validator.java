package com.example.BookStore.ServiceImpl;

import java.time.Year;

public class Validator {
    public static boolean isValidPublicationYear(int year){
        return year <= Year.now().getValue();
    }

    public static boolean isValidISBN(String isbn) {
        if(isbn == null || isbn.isEmpty()){
            return false;
        }
        isbn = isbn.replace("-", "");
        if(isbn.length()!=10 || isbn.length()!=13){
            return false;
        }
        if (isbn.length() == 10) {
            return isValidISBN10(isbn);
        } else {
            return isValidISBN13(isbn);
        }
    }

    private static boolean isValidISBN10(String isbn) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            char c = isbn.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            sum += (10 - i) * Character.getNumericValue(c);
        }
        char lastChar = isbn.charAt(9);
        if (lastChar == 'X') {
            sum += 10;
        } else if (!Character.isDigit(lastChar)) {
            return false;
        } else {
            sum += Character.getNumericValue(lastChar);
        }
        return sum % 11 == 0;
    }

    private static boolean isValidISBN13(String isbn) {
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            char c = isbn.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            sum += (i % 2 == 0) ? Character.getNumericValue(c) : Character.getNumericValue(c) * 3;
        }
        int checkDigit = Character.getNumericValue(isbn.charAt(12));
        int remainder = sum % 10;
        return (10 - remainder) % 10 == checkDigit;
    }
}
