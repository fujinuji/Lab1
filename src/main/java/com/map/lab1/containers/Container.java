package com.map.lab1.containers;

public interface Container<T> {
    void add(T element);

    boolean isEmpty();

    T[] getElements();
}
