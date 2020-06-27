package domain;

import database.OracleBaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Product extends OracleBaseDao {
    Connection conn=getConnection();


    private String omschrijving;
    private String categorie;
    private String landvherkomst;
    private double kiloprijs;
    private static ArrayList<Product> products=new ArrayList<>();

    public double getkiloprijs() {
        return kiloprijs;
    }

    public Product(String omschrijving, String categorie, String landvherkomst, double startprijs) throws SQLException {
        this.categorie=categorie;
        this.omschrijving=omschrijving;
        this.landvherkomst=landvherkomst;
        this.kiloprijs=startprijs;
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
