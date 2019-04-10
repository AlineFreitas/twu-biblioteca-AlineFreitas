package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserHandler {
    private static List<User> userList;

    public static User login(String libraryNumber, String password) {
        User user = getUserByLibraryNumber(libraryNumber);

        if (user != null && user.verifyPassword(password)) {
            return user;
        }

        return null;
    }

    public static User getUserByLibraryNumber(String libraryNumber) {
        for (User user: userList) {
            if (user.getLibraryNumber().equals(libraryNumber)) {
                return user;
            }
        }
        return null;
    }

    public static void setUserList() {
        userList = new ArrayList<User>();
        userList.add(new User("123-4567", "senha"));
        userList.add(new User("123-4568", "outra senha"));
    }
}
