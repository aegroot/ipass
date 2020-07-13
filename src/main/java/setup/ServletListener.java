package setup;


import domain.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;

@WebListener
public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            //inladen casus
            Product.loadProducten();
            Account.loadklanten();
            Account.loadwinkels();

            //voor testen
            Winkel.setWinkelonline(Winkel.getwinkelbycode("XYZ01"));
            Klant.setOnline(Klant.getbyUsername("gast"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}