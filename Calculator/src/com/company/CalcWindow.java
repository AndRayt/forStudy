package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Окно калькулятора
 * Created by Андрей on 09.04.2017.
 */
public class CalcWindow extends JFrame {
    String userLogin ="";
    JTextArea display = new JTextArea(2,4);
    JPanel bPanel = new JPanel();
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton buttonSum = new JButton("+");
    JButton buttonC = new JButton("C");//кнопка удалить все
    JButton buttonDiv = new JButton("/");//кнопка /
    JButton buttonSub = new JButton("-");//кнопка -
    JButton buttonMul = new JButton("*");//кнопка *
    JButton buttonRes = new JButton("=");//кнопка =
    JButton buttonPM = new JButton("+/-");//кнопка +/-
    JButton buttonDel = new JButton("Delete");//кнопка удалить символ
    JButton buttonRBracket = new JButton("("); //точка
    JButton buttonLBracket = new JButton(" )");
    CalcWindow(String userLogin) {
        super("Калькулятор");
        Logging.write(userLogin,"Enter to calculator");
        this.userLogin = userLogin;
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        bPanel.setLayout(new GridLayout(5,4,0,0));
        add(display,BorderLayout.NORTH);
        add(bPanel,BorderLayout.CENTER);
        bPanel.add(button7);
        bPanel.add(button8);
        bPanel.add(button9);
        bPanel.add(buttonDiv);
        bPanel.add(button4);
        bPanel.add(button5);
        bPanel.add(button6);
        bPanel.add(buttonMul);
        bPanel.add(button1);
        bPanel.add(button2);
        bPanel.add(button3);
        bPanel.add(buttonSub);
        bPanel.add(buttonC);
        bPanel.add(button0);
        bPanel.add(buttonRes);
        bPanel.add(buttonSum);
        bPanel.add(buttonPM);
        bPanel.add(buttonRBracket);
        bPanel.add(buttonLBracket);
        bPanel.add(buttonDel);
        setBounds(300, 300, 300, 300);
    }
}
