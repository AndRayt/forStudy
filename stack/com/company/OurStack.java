package com.company;

/**
 * Класс реализующий стек
 * Created by Андрей Райцын on 28.03.2017.
 */
public class OurStack {
    private int size; //Размер стека
    private int[] array; //Массив элементов стека
    private int top; //Номер вершины стека

    /**
     * Конструктор по умолчанию
     */
    public OurStack() {
        this.size = 10;
        array = new int[this.size];
        top = -1;
    }

    /**
     * Перегруженный конструктор
     * @param size
     */
    public OurStack(int size) {
        this.size = size;
        array = new int[size];
        top = -1;
    }

    /**
     * Добавление элемента
     * @param element
     */
    public void push(int element) {
        if (top < size) {
            top++;
            array[top] = element;
        }
    }

    /**
     * Взятие элемента
     * @return последний элемент в стеке
     */
    public int pop() {
        if (top >= -1) {
            int value = array[top];
            array[top] = 0;
            top--;
            return value;
        } return 0;
    }

    /**
     * Просмотр элемента
     * @return последний элемент в стеке
     */
    public int back() {
        return array[top];
    }

    /**
     * Размер сегмента стека
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Адресс вершины (относительно сегмента стека)
     * @return
     */
    public int getTop() {
        return top;
    }
}
