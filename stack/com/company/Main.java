package com.company;

public class Main {

    public static void main(String[] args) {
        //Проверка работы стека
	    OurStack stack = new OurStack();
	    for (int i = 0; i < 10; i++) {
	        stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }
}
