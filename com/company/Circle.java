package com.company;

/**
 * Окружность
 * Created by Андрей on 28.03.2017.
 */
public class Circle implements Figure {
    private double r;
    /*
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию
     */
    Circle() {
        r = 1;
    }

    /**
     * Конструктор перегруженный
     * @param r
     */
    Circle(double r) {
        set(r);
    }

    /**
     * Сеттер
     * @param r
     */
    void set(double r) {
        this.r = r;
    }

    /**
     * Площадь
     * @return PI*r*r
     */
    @Override
    public double area() {
        return Math.PI*r*r;
    }

    /**
     * Периметр
     * @return 2*PI*r
     */
    @Override
    public double perimeter() {
        return 2*Math.PI*r;
    }
}
