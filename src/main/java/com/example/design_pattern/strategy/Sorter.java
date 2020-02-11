package com.example.design_pattern.strategy;

import java.lang.Comparable;

public interface Sorter<T> {
    public abstract void sort(Comparable<T>[] data);
}
