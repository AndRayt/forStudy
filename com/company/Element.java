package com.company;

/**
 * Created by Андрей on 31.03.2017.
 */
public class Element {
    private int data;
    private Element prevElement;

    Element (int data) {
        this.data = data;
    }

    Element (int data, Element prevElement) {
        this.data = data;
        setPrevElement(prevElement);
    }

    void setPrevElement(Element prevElement) {
        this.prevElement = prevElement;
    }


    void setData(int data) {
        this.data = data;
    }

    int getData() {
        return data;
    }

    Element getPrevElement() {
        return prevElement;
    }
}
