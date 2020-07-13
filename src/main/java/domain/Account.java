package domain;

import database.OracleBaseDao;

import java.sql.*;
import java.util.ArrayList;

public abstract class Account extends OracleBaseDao {

    public String username;
    public String password;
    private static ArrayList<Account>accounts=new ArrayList<>();

    public Account(String username, String password) throws SQLException {
        this.username=username;
        this.password=password;
        accounts.add(this);
    }

    public static void loadklanten(){
        String query="select * from klantcred";
        try {
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String username=resultSet.getString("username");
                String password=resultSet.getString("password");
                String naam=resultSet.getString("naam");
                new Klant(naam,username,password);
            } closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void loadwinkels(){

        try {
            Connection conn=getConnection();
            Statement statement=conn.createStatement();
            String query="select * from winkelcred";
            ResultSet resultSet =statement.executeQuery(query);
            while (resultSet.next()){
                String username=resultSet.getString("username");
                String password=resultSet.getString("password");
                String code=resultSet.getString("code");
                String stad=resultSet.getString("stad");
                 Winkel winkel=new Winkel(username,password,code,stad);

                PreparedStatement preparedStatement=conn.prepareStatement("select * from winkelassortiment " +
                        "where winkelcode =? ");
                preparedStatement.setString(1,winkel.getWinkelcode());
                ResultSet resultSet1=preparedStatement.executeQuery();
                while (resultSet1.next()) {
                    int aproductid = resultSet1.getInt("productid");
                    int hoeveelheid = resultSet1.getInt("hoeveelheid");
                    //String winkelcode = resultSet1.getString("winkelcode");

                    PreparedStatement preparedStatement1 = conn.prepareStatement("select * from product where id =?");
                    preparedStatement1.setInt(1, aproductid);
                    ResultSet resultSet2 = preparedStatement1.executeQuery();
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
                    }
                    winkel.addProduct(new AssortimentProduct(new Product(omschrijving, categorie, landvherkomst, kiloprijs),aproductid,hoeveelheid));
                }

            }closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public static boolean validate(String email, String password){
        for (Account account:accounts) {
            if (account.username==email && account.password==password){return true;}
        }
        return false;
    }
}
