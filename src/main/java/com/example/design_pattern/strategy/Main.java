package com.example.design_pattern.strategy;

public class Main {
	public static void main(String[] args) {
		String[] data1 = { "Dumpty", "Bowman", "Carroll", "Elfland", "Alice", };
		SortAndPrint<String> sap1 = new SortAndPrint<>(data1, new QuickSorter<>());
		sap1.execute();

		String[] data2 = { "Dumpty", "Bowman", "Carroll", "Elfland", "Alice", };
		SortAndPrint<String> sap2 = new SortAndPrint<>(data2, new InsertionSorter<>());
		sap2.execute();

		Integer[] data3 = { 5, 4, 3, 2, 6, 7, 8, 1, 9 };
		SortAndPrint<Integer> sap3 = new SortAndPrint<>(data3, new InsertionSorter<>());
		sap3.execute();
	}
}
