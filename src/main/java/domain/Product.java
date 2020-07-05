package domain;

import database.OracleBaseDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Product extends OracleBaseDao {



    private String omschrijving;
    private String categorie;
    private String landvherkomst;
    private double kiloprijs;
    private static ArrayList<Product> products=new ArrayList<>();

    public double getkiloprijs() {
        return kiloprijs;
    }

    public static void loadProducten() throws SQLException {
        Connection conn= null;

            conn = getConnection();
            String query="select * from product";
            Statement Statement = conn.createStatement();
            ResultSet resultSet2 = Statement.executeQuery(query);
            String omschrijving = null;
            String categorie = null;
            String landvherkomst = null;
            double kiloprijs = 0;
            while (resultSet2.next()) {
                //int id = resultSet2.getInt("id");
                omschrijving = resultSet2.getString("omschrijving");
                categorie = resultSet2.getString("categorie");
                landvherkomst = resultSet2.getString("landvherkomst");
                kiloprijs = resultSet2.getDouble("kiloprijs");
                new Product(omschrijving,categorie,landvherkomst,kiloprijs);

            }}


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
