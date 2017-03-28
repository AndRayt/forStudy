package com.company;

/**
 * Квадрат
 * Created by Андрей on 28.03.2017.
 */
public class Square extends Rectangle {
    Square() {
        a = 1;
        b = 1;
    }
    Square(double a) {
        set(a,a);
    }
}
