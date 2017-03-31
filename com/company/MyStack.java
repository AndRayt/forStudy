package com.company;

/**
 * Created by Андрей on 31.03.2017.
 */
public class MyStack {
    private int size; //Размер стека
    private int top; //Номер вершины стека
    private Element sElement;

    /**
     * Конструктор по умолчанию
     */
    public MyStack() {
        this.size = 10;
        sElement = new Element(0);
        top = -1;
    }

    /**
     * Перегруженный конструктор
     * @param size
     */
    public MyStack(int size) {
        this.size = size;
        top = -1;
    }

    /**
     * Добавление элемента
     * @param element
     */
    public void push(int element) {
        if (top < (size - 1)) {
            top++;
            sElement = new Element(element, sElement);
           // fElement = sElement;
        }
    }

    /**
     * Взятие элемента
     * @return последний элемент в стеке
     */
    public int pop() {
        if (top >= -1) {
            int value = sElement.getData();
            top--;
            sElement = sElement.getPrevElement();
            return value;
        } return 0;
    }

    /**
     * Просмотр элемента
     * @return последний элемент в стеке
     */
    public int back() {
        return sElement.getData();
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
