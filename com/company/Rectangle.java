package com.company;

/**
 * Класс Прямоугольник
 * Created by Андрей on 28.03.2017.
 */
public class Rectangle implements Figure{
    protected double a;
    protected double b;
    /*
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию
     */
    Rectangle() {
        a = 1;
        b = 1;
    }

    /**
     * Конструктор перегруженный
     * @param a
     * @param b
     */
    Rectangle(double a, double b) {
        set(a,b);
    }

    /**
     * Сеттер
     * @param a
     * @param b
     */
    void set(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Площадь
     * @return a*b
     */
    @Override
    public double area() {
        return a*b;
    }

    /**
     * Периметр
     * @return a + b
     */
    @Override
    public double perimeter() {
        return a+b;
    }
}
