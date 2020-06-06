package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KlantTest {
    @BeforeAll
    static void crecase(){
        Product p1=new Product(" appel","fruit","nederland",2);
        Product p2=new Product(" manderijn","fruit","nederland",7.5);
        Klant k1=new Klant("jos", "jos@test.nl", "test");
        Winkelwagen w1=new Winkelwagen(1);
        k1.setWinkelwagen(w1);
        AssortimentProduct a1=new AssortimentProduct(p1,0.5);
        AssortimentProduct a2=new AssortimentProduct(p2,0.25);
        w1.addproduct(a1);
        w1.addproduct(a2);
        Klant.setOnline(k1);
    }

    @Test
    void setOnlineleeg() {
        Klant k3=null;
        Klant.setOnline(k3);
        Klant klant=Klant.getOnline();
        assertEquals(k3,klant);
    }

    @Test
    void getbyaccount() {

    }

    @Test
    void getProducts() {
    }

    @Test
    void getbyaccountset() {
        Klant k1=new Klant("jos", "jos@test.nl", "test");
        assertEquals(k1,Klant.getbyaccount("jos@test.nl", "test"));

    }
}