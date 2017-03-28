package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("Выберите фигуру:\n1)Окружность\n2)Треугольник\n3)Прямоугольник\n4)Квадрат\nНаберите соотвествующию цифру");
        int wht;
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()) {
            wht = sc.nextInt();
            if ((wht < 1) || (wht > 4)) {
                System.out.println("Вы ввели неверное число");
            }
            else {
                System.out.println("Что вы хотитете вычислить?\n1)Площадь\n2)Периметр\nНаберите соотвествующию цифру");
                int wht2;
                if(sc.hasNextInt()) {
                    wht2 = sc.nextInt();
                    if ((wht2 < 1) || (wht2 > 2)) {
                        System.out.println("Вы ввели неверное число");
                    } else {
                        //Окружность
                        if (wht == 1) {
                            double r;
                            System.out.println("Введите радиус: ");
                            if(sc.hasNextDouble()) {
                                r = sc.nextDouble();
                                Circle circle = new Circle(r);
                                if (wht2 == 1) System.out.println("Площадь: "+circle.area());
                                if (wht2 == 2) System.out.println("Длинна окружности: "+circle.perimeter());
                            } else {
                                System.out.println("Вы ввели неверное число");
                            }
                        }
                        //Треугольник
                        if (wht == 2) {
                            double osn;
                            double h;
                            System.out.println("Введите оснвоание: ");
                            if(sc.hasNextDouble()) {
                                osn = sc.nextDouble();
                                System.out.println("Введите высоту: ");
                                if(sc.hasNextDouble()) {
                                    h = sc.nextDouble();
                                    Triangle triangle = new Triangle(osn,h);
                                    if (wht2 == 1) System.out.println("Площадь: "+triangle.area());
                                    if (wht2 == 2) System.out.println("Периметр: "+triangle.perimeter());
                                } else {
                                    System.out.println("Вы ввели неверное число");
                                }
                            } else {
                                System.out.println("Вы ввели неверное число");
                            }
                        }
                        //Прямоугольник
                        if (wht == 3) {
                            double a;
                            double b;
                            System.out.println("Введите a: ");
                            if(sc.hasNextDouble()) {
                                a = sc.nextDouble();
                                System.out.println("Введите b: ");
                                if(sc.hasNextDouble()) {
                                    b = sc.nextDouble();
                                    Rectangle rectangle = new Rectangle(a,b);
                                    if (wht2 == 1) System.out.println("Площадь: "+rectangle.area());
                                    if (wht2 == 2) System.out.println("Периметр: "+rectangle.perimeter());
                                } else {
                                    System.out.println("Вы ввели неверное число");
                                }
                            } else {
                                System.out.println("Вы ввели неверное число");
                            }
                        }
                        //Квадрат
                        if (wht == 4) {
                            double a;
                            System.out.println("Введите a: ");
                            if(sc.hasNextDouble()) {
                                a = sc.nextDouble();
                                Square square = new Square(a);
                                if (wht2 == 1) System.out.println("Площадь: "+square.area());
                                if (wht2 == 2) System.out.println("Периметр: "+square.perimeter());
                            } else {
                                System.out.println("Вы ввели неверное число");
                            }
                        }
                    }
                } else {
                    System.out.println("Вы ввели не целое число");
                }
            }
        } else {
            System.out.println("Вы ввели не целое число");
        }
    }
}
