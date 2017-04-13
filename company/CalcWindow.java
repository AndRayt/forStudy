package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Андрей on 12.04.2017.
 */

public class CalcWindow extends JFrame {
        double fValue;
        int operation;
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
        JButton buttonPoint = new JButton("."); //точка
        CalcWindow() {
            super("Калькулятор");
            fValue = 0;
            operation = 0;
            setLayout(new BorderLayout());
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setResizable(false);
            button0.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText()+"0");
                }
            });
            button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText()+"1");
                }
            });
            button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText()+"2");
                }
            });
            button3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText()+"3");
                }
            });
            button4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText()+"4");
                }
            });
            button5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText()+"5");
                }
            });
            button6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText()+"6");
                }
            });
            button7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText()+"7");
                }
            });
            button8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText()+"8");
                }
            });
            button9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText()+"9");
                }
            });
            buttonDel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!(display.getText().equals(""))) {
                        display.setText(display.getText().substring(0, display.getText().length() - 1));
                    }
                }
            });
            buttonPM.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!(display.getText().equals(""))) {
                        if (!(display.getText().substring(0, 1).equals("-"))) {
                            display.setText("-" + display.getText());
                        } else {
                            display.setText(display.getText().replace("-", ""));
                        }
                    }
                }
            });
            buttonC.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    display.setText("");
                }
            });
            buttonPoint.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    display.setText(display.getText() + ".");
                }
            });
            buttonSum.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fValue = Double.valueOf(display.getText());
                    operation = 1;
                    display.setText("");
                }
            });
            buttonSub.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fValue = Double.valueOf(display.getText());
                    operation = 2;
                    display.setText("");
                }
            });
            buttonMul.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fValue = Double.valueOf(display.getText());
                    operation = 3;
                    display.setText("");
                }
            });
            buttonDiv.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fValue = Double.valueOf(display.getText());
                    operation = 4;
                    display.setText("");
                }
            });
            buttonRes.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    double result;
                if (fValue != 0 && operation != 0 && Double.valueOf(display.getText()) != 0) {
                    switch (operation) {
                        case 1: result = fValue + Double.valueOf(display.getText()); break;
                        case 2: result = fValue - Double.valueOf(display.getText()); break;
                        case 3: result = fValue * Double.valueOf(display.getText()); break;
                        case 4: result = fValue / Double.valueOf(display.getText()); break;
                        default: result = 0; break;
                    }
                    display.setText(String.valueOf(result));
                }
                }
            });
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
            bPanel.add(buttonPoint);
            bPanel.add(buttonDel);
            setBounds(300, 300, 300, 300);
        }
}
