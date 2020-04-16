package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinkelTest {


    @Test
    void plusBudget() {
        Winkel henk=new Winkel("henk", 1000);
        double init=henk.getBudget();
        henk.plusBudget(100);
        assertNotEquals(init,henk.getBudget());
    }

    @Test
    void plusbudgetminus(){
        Winkel henk=new Winkel("henk", 1000);
        double init=henk.getBudget();
        henk.plusBudget(-100);
        assertEquals(init,henk.getBudget());

    }
}