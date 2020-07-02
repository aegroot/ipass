package domain;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class WinkelTest {


    @Test
    void plusBudget() {
        try {
            Winkel henk=new Winkel("henk", "test","1","test");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Test
    void plusbudgetminus(){
        try {
            Winkel henk=new Winkel("henk", "henk","1","test");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}