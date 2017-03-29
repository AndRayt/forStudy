package com.company;

/**
 * Комплексные числа
 * Created by Андрей Райцын on 29.03.2017.
 */
public class ComplexNumber {
    double x; //действительная часть
    double y; //мнимая часть

    ComplexNumber() {
        this.x = 0;
        this.y = 0;
    }

    ComplexNumber(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    /**
     * Взятие модуля
     * @return
     */
    double abs () {
        return Math.sqrt(x*x + y*y);
    }

    /**
     * Ссложение
     * @param CN
     * @return
     */
    ComplexNumber add(ComplexNumber CN) {
        ComplexNumber result = new ComplexNumber();
        result.x = this.x + CN.x;
        result.y = this.y + CN.y;
        return result;
    }

    /**
     * Вычитание
     * @param CN
     * @return
     */
    ComplexNumber sub(ComplexNumber CN) {
        ComplexNumber result = new ComplexNumber();
        result.x = this.x - CN.x;
        result.y = this.y - CN.y;
        return result;
    }

    /**
     * Умножение
     * @param CN
     * @return
     */
    ComplexNumber mult(ComplexNumber CN) {
        ComplexNumber result = new ComplexNumber();
        result.x = this.x * CN.x - this.y * CN.y;
        result.y = this.y * CN.x + this.x * CN.y;
        return result;
    }

    /**
     * Деление
     * @param CN
     * @return
     */
    ComplexNumber div(ComplexNumber CN) {
        ComplexNumber result = new ComplexNumber();
        result.x = (this.x * CN.x + this.y * CN.y)/(CN.x*CN.x + CN.y*CN.y);
        result.y = (this.y * CN.x - this.x * CN.y)/(CN.x*CN.x + CN.y*CN.y);
        return result;
    }

    public String toString() {
        String result;
        result = Double.toString(this.x) + " + (" + Double.toString(this.y) + ")*i";
        return result;
    }
}
