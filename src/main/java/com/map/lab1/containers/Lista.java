package com.map.lab1.containers;


public class Lista<T> implements Container {
    private int size;
    private T[] elements;

    Lista(int size) {
        //this.elements = new T[size];
    }

    @Override
    public void add(Object element) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] getElements() {
        return this.elements;
    }
}
