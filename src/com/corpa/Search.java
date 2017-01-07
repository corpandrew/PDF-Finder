package com.corpa;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by corpa on 1/6/17.
 */

public class Search implements Runnable {

    private Book book;

    public Search(Book book) {
        this.book = book;
    }

    @Override
    public void run() {
        searchForBook();
    }

    private void searchForBook() {
        Document doc = null;
        try {
            doc = Jsoup.connect(book.getURL()).userAgent("Mozilla").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = "";
        if (doc != null) {
            Elements titles = doc.select("h3.r > a");

            int length = book.getResults();
            if (length == 0) {
                System.out.println("Couldn't find any results. Try being less specific.");
                if (!book.getAuthor().equals(""))
                    System.out.println("You could try leaving author name blank");
                System.out.println("Ending program!");
                System.exit(0);
            } else if(titles.size() < length) {
                System.out.println("Couldn't find that many results, showing what we've found.");
                length = titles.size();
            }

            for (Element e : titles.subList(0, length)) { // use only the best ones (top 5 results) or if list is shorter than just that length.
                url = e.attr("href");
                if (url.contains(".pdf")) {
                    url = url.substring(7, url.indexOf(".pdf") + 4);
                    try {
                        java.awt.Desktop.getDesktop().browse(new URI(url));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (URISyntaxException e2) {
                        e2.printStackTrace();
                    }
                    System.out.println(url);
                }
            }
        }

    }

}
