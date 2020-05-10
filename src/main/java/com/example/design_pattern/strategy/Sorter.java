package com.example.design_pattern.strategy;

public interface Sorter<T extends Comparable<T>> {
	public abstract void sort(T[] data);
}
