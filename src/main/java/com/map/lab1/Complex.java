package com.map.lab1;

public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex() {
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public Complex add(Complex number) {
        this.imaginary += number.getImaginary();
        this.real += number.getReal();

        return this;
    }

    public Complex substract(Complex number) {
        this.real -= number.getReal();
        this.imaginary -= number.getImaginary();
        return this;
    }

    public Complex multiply(Complex number) {
        this.real = this.real * number.getReal() - this.imaginary * number.getImaginary();
        this.imaginary = this.real * number.getImaginary() + this.imaginary * number.getReal();

        return this;
    }

    public Complex division(Complex number) {
        this.real = (this.real * number.getReal() + this.imaginary * number.getImaginary()) /
                (Math.pow(number.getReal(), 2) + Math.pow(number.getImaginary(), 2));
        this.imaginary = (this.imaginary * number.getReal() - this.real * number.getImaginary()) /
                (Math.pow(number.getReal(), 2) + Math.pow(number.getImaginary(), 2));

        return this;
    }

    @Override
    public String toString() {
        return real + (imaginary >= 0 ? "+" : "") + imaginary + "*i";
    }
}
