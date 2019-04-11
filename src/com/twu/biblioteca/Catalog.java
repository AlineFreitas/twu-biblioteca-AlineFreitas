package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Catalog {

    private List<Borrowable> items;
    private HashMap<String, String> borrowLog;

    public void addItem(Borrowable item) {
        this.items.add(item);
    }


    public List<Borrowable> getItems() {
        return items;
    }


    public Catalog() {
        this.items = new ArrayList<Borrowable>();
        this.borrowLog = new HashMap<String, String>();
    }

    public boolean borrowItem(String title, String userLibNumber) {

        Borrowable item = getByTitle(title);

        if (item == null || borrowLog.containsKey(title)) {
            System.out.println("Sorry, that item is not available");
            return false;
        } else {
            borrowLog.put(title, userLibNumber);
            System.out.println("Thank you! Enjoy the " + item.getClass().getSimpleName());
            return true;
        }
    }

    public Borrowable getByTitle(String title) {

        for (Borrowable item : items) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    public List<Borrowable> getAvailableItems() {
        List<Borrowable> available = new ArrayList<Borrowable>();

        for (Borrowable item : items) {
            if (!borrowLog.containsKey(item.getTitle())) {
                available.add(item);
            }
        }

        return available;
    }

    public boolean returnItem(String title) {
        Borrowable item = getByTitle(title);

        if (item != null && borrowLog.containsKey(title)) {
            borrowLog.remove(title);
            System.out.println("Thanks for returning the " + item.getClass().getSimpleName());
            return true;
        } else {
            System.out.println("That is not a valid " + item.getClass().getSimpleName() + " to return.");
            return false;
        }
    }
}