package org.baktygaliyev;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ProductCrawler {
    public static void main(String[] args) {
        String url = "https://kolesa.kz/cars/";
        try {
            Document document = Jsoup.connect(url).get();
            Elements products = document.select(".a-list__item");
            int numberOfProduct = 1;
            for (Element product : products) {
                String title = product.select(".a-card__link").text();
                String description = product.select(".a-card__description").text();
                String price = product.select(".a-card__price").text();
                System.out.println("====Product number " + numberOfProduct + ": ");
                System.out.println("Title: " + title);
                System.out.println("Description: " + "`" + description + "`");
                System.out.println("Price: " + price);
                System.out.println();
                numberOfProduct++;
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
