package service;

import model.User;

public class UserCreator {

    public static final String USER_NAME = "elizaveta.gubich@mail.ru";
    public static final String USER_PASSWORD = "Qwerty123333";

    public static User withCredentialsFromProperty(){
        return new User(USER_NAME, USER_PASSWORD);
    }

    public static User withEmptyUsername(){
        return new User("", USER_PASSWORD);
    }

    public static User withEmptyPassword(){
        return new User(USER_NAME, "");
    }
}
