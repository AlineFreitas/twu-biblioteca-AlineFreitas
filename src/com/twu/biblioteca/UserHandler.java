package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class UserHandler {
    private static List<User> userList;

    public static boolean login(String libraryNumber, String password) {
        User user = getUserByLibraryNumber(libraryNumber);

        if (user != null) {
            return user.verifyPassword(password);
        }

        return false;
    }

    private static User getUserByLibraryNumber(String libraryNumber) {
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
    }
}
