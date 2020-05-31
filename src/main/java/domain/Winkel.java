package domain;

import java.util.ArrayList;

public class Winkel extends Account {
    private ArrayList<AssortimentProduct>producten;
    private String winkelcode;
    private String stad;
    private static ArrayList<Winkel>winkels;
    private static Winkel winkelonline;

    public static ArrayList<Winkel> getWinkels() {
        return winkels;
    }

    public static void setWinkelonline(Winkel winkelonline) {
        Winkel.winkelonline = winkelonline;
    }

    public void setWinkelcode(String winkelcode) {
        this.winkelcode = winkelcode;
    }

    public String getWinkelcode() {
        return winkelcode;
    }

    public static Winkel getwinkelbycode(String code){
        for (Winkel winkel:winkels) {
            if (winkel.getWinkelcode()==code){
                return winkel;

            }
        }

        return null;
    }

    public static Winkel getWinkelonline() {
        return winkelonline;
    }




    public Winkel(String username,String password,String winkelcode,String stad) {
        super(username, password);
        this.winkelcode = winkelcode;
        this.stad=stad;
        winkels.add(this);
    }




    public ArrayList<AssortimentProduct> getProducten() {
        return producten;
    }

    public static Winkel getbyaccount(String username,String password){
        for (Winkel winkel:winkels) {
            if((winkel.getUsername()==username)&&(winkel.password==password)){
                return winkel;
            }
        }
        return null;
    }

}

