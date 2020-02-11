package com.example.design_pattern.strategy;

public class Main {
    public static void main(String[] args) {
        String[] data = {
            "Dumpty", "Bowman", "Carroll", "Elfland", "Alice",
        };
        //SortAndPrint<String> sap = new SortAndPrint<>(data, new QuickSorter<String>());
        SortAndPrint sap = new SortAndPrint(data, new QuickSorter());
        sap.execute();
    }
}
