package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinkelTest {


    @Test
    void plusBudget() {
        Winkel henk=new Winkel("henk", "test","1","test");


    }

    @Test
    void plusbudgetminus(){
        Winkel henk=new Winkel("henk", "henk","1","test");

    }
}