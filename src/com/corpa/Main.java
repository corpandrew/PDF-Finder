package com.corpa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String title, author;
        int results;
        char keepGoing = ' ';

        do {
            System.out.println("Title of book: ");
            title = s.nextLine();
            System.out.println("Author: ");
            author = s.nextLine();
            System.out.println("How many of the results would you like to look at for this book?: ");
            results = s.nextInt();

            bookList.add(new Book(title, author, results));

            System.out.println("Would you like to keep going? (n for no): ");
            keepGoing = s.next().charAt(0);
        } while (keepGoing != 'N' && keepGoing != 'n');

        for (Book b : bookList) {
            System.out.println(b.getTitle());
            new Search(b).run();
        }
    }
}