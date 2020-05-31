package domain;

import java.util.ArrayList;

public class Product {
    private String omschrijving;
    private String categorie;
    private String landvherkomst;
    private double startprijs;
    private static ArrayList<Product> products=new ArrayList<>();

    public double getStartprijs() {
        return startprijs;
    }

    public Product(String omschrijving, String categorie, String landvherkomst, double startprijs) {
        this.categorie=categorie;
        this.omschrijving=omschrijving;
        this.landvherkomst=landvherkomst;
        this.startprijs=startprijs;
        products.add(this);
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getLandvherkomst() {
        return landvherkomst;
    }

    public static ArrayList<Product> getProducts(){
        return products;
    }
}
