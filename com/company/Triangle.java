package com.company;

/**
 * Треугольник
 * Created by Андрей on 28.03.2017.
 */
public class Triangle implements Figure{
    private double osn;
    private double h;
    /*
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию
     */
    Triangle() {
        osn = 1;
        h = 1;
    }

    /**
     * Конструктор перегруженный
     * @param osn
     * @param h
     */
    Triangle(double osn, double h) {
        setArea(osn,h);
    }

    /**
     * Сеттер
     * @param osn
     * @param h
     */
    void setArea(double osn, double h) {
        this.osn = osn;
        this.h = h;
    }

    /**
     * Площадь
     * @return 0.5*osn*h
     */
    @Override
    public double area() {
        return 0.5*osn*h;
    }

    /**
     * Периметр
     * @return Math.sqrt(4*h*h + osn*osn) + osn
     */
    @Override
    public double perimeter() {
        return Math.sqrt(4*h*h + osn*osn) + osn;
    }
}
