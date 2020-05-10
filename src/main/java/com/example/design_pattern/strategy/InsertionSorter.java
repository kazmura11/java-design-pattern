package com.example.design_pattern.strategy;

public class InsertionSorter<T extends Comparable<T>> implements Sorter<T> {
	T[] data;

	@Override
	public void sort(T[] data) {
		this.data = data;
		isort(data);
	}

	private void isort(T[] data) {
		for (int left = 1; left < data.length; left++) {
			for (int right = left; right > 0 && data[right - 1].compareTo(data[right]) > 0; right--) {
				swap(data, right - 1, right);
			}
		}
	}

	public void swap(final T[] arr, final int pos1, final int pos2) {
		final T temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
}
