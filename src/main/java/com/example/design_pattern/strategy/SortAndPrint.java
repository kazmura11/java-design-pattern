package com.example.design_pattern.strategy;

public class SortAndPrint<T extends Comparable<T>> {
	T[] data;
	Sorter<T> sorter;

	public SortAndPrint(T[] data, Sorter<T> sorter) {
		this.data = data;
		this.sorter = sorter;
	}

	public void execute() {
		print();
		sorter.sort(data);
		print();
	}

	public void print() {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ", ");
		}
		System.out.println("");
	}
}
