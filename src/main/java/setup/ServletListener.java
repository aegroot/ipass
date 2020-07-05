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
            Product.loadProducten();
            Account.loadklanten();
            Account.loadwinkels();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}