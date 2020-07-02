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
        Product p1= null;
        try {
            p1 = new Product(" appel","fruit","nederland",2);
            Product p2=new Product(" manderijn","fruit","nederland",7.5);
            Klant k1=new Klant("jos", "jos@test.nl", "test");
            Winkelwagen w1=new Winkelwagen();
            k1.setWinkelwagen(w1);
            AssortimentProduct a1=new AssortimentProduct(p1, 1, 0.5);
            AssortimentProduct a2=new AssortimentProduct(p2, 2, 0.25);
            w1.addproduct(a1);
            w1.addproduct(a2);
            Klant.setOnline(k1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}