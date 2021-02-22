package Exam2;

import java.util.ArrayList;

public class User{
    private String name;
    private String nickname;
    private String password;
    private ArrayList<User> myContacts;

    public User(String name, String nickname, String password) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        myContacts = new ArrayList<>();
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }
}
