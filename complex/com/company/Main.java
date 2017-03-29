package com.company;

import java.util.Scanner;

/**
 * Калькулятор комплексных чисел
 * @author Андрей Райцын
 */
public class Main {

    public static void main(String[] args) {
        double x = 0, y = 0;
        System.out.println("Введите Z1: ");
        System.out.println("Введите действительную часть: ");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextDouble()) {
            x = sc.nextDouble();
            System.out.println("Введите мнимую часть: ");
            if(sc.hasNextDouble()) {
                y = sc.nextDouble();
                ComplexNumber z1 = new ComplexNumber(x,y);
                System.out.println("1) Найти модуль \n2) Ввести z2");
                int wht;
                if(sc.hasNextInt()) {
                    wht = sc.nextInt();
                    if (wht == 1 || wht == 2) {
                        if (wht == 1) {
                            System.out.println("|Z| = " + z1.abs());
                        }

                        if (wht == 2) {
                            double x2 = 0, y2 = 0;
                            System.out.println("Введите действительную часть: ");
                            if(sc.hasNextDouble()) {
                                x2 = sc.nextDouble();
                                System.out.println("Введите мнимую часть: ");
                                if(sc.hasNextDouble()) {
                                    y2 = sc.nextDouble();
                                    ComplexNumber z2 = new ComplexNumber(x2, y2);
                                    ComplexNumber result = new ComplexNumber(0, 0);
                                    int wht2 = 0;
                                    System.out.println("1) Сложение\n2) Вычитание\n3) Умножение\n4) Деление");
                                    if(sc.hasNextInt()) {
                                        wht2 = sc.nextInt();
                                        if (wht2 == 1) {
                                            System.out.println("result = " + z1.add(z2).toString());
                                        }
                                        if (wht2 == 2) {
                                            System.out.println("result = " + z1.sub(z2).toString());
                                        }
                                        if (wht2 == 3) {
                                            System.out.println("result = " + z1.mult(z2).toString());
                                        }
                                        if (wht2 == 4) {
                                            System.out.println("result = " + z1.div(z2).toString());
                                        }
                                    } else {
                                        System.out.println("Вы ввели неверное число");
                                    }
                                } else {
                                    System.out.println("Вы ввели неверное число");
                                }
                            } else {
                                System.out.println("Вы ввели неверное число");
                            }
                        }
                    } else {
                        System.out.println("Введите 1 или 2");
                    }
                } else {
                    System.out.println("Вы ввели неверное число");
                }
            } else {
                System.out.println("Вы ввели неверное число");
            }
        } else {
            System.out.println("Вы ввели неверное число");
        }
    }
}
