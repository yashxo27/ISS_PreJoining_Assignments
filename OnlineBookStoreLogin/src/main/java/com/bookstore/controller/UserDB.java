package com.bookstore.controller;

import java.util.HashMap;

public class UserDB {
    private static final HashMap<String, String> users = new HashMap<>();

    static {
        users.put("user@example.com", "1234");
    }

    public static boolean exists(String email, String password) {
        return password.equals(users.get(email));
    }

    public static boolean exists(String email) {
        return users.containsKey(email);
    }

    public static void addUser(String email, String password) {
        users.put(email, password);
    }
}
