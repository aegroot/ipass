package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KlantTest {

    @Test
    void minusBudgetinsuf(){
        Klant henk=new Klant(1000,"henk");
        double init=henk.getBudget();
        henk.minusBudget(10000);
        assertEquals(init,henk.getBudget());
    }
    @Test
    void minusBudgetnegative(){
        Klant henk=new Klant(1000,"henk");
        double init=henk.getBudget();
        henk.minusBudget(-1);
        assertEquals(init,henk.getBudget());

    }
    @Test
    void minusBudgetgood(){
        Klant henk=new Klant(1000,"henk");
        double init=henk.getBudget();
        henk.minusBudget(100);
        assertNotEquals(init,henk.getBudget());
    }


}