package domain;

import java.util.ArrayList;

public abstract class Account {
    public String username;
    public String password;
    private static ArrayList<Account>accounts=new ArrayList<>();

    public Account(String username, String password) {
        this.username=username;
        this.password=password;
        accounts.add(this);
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
