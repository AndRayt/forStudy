package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * Движок калькулятора
 * Created by Андрей on 26.04.2017.
 */
public class CalcEngine {
    CalcWindow calcWindow;
    Cache cache;
    CalcEngine (String userLogin) {
        calcWindow = new CalcWindow(userLogin);
        calcWindow.setVisible(true);
        cache = new Cache();
        calcWindow.button0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"0");
            }
        });
        calcWindow.button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"1");
            }
        });
        calcWindow.button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"2");
            }
        });
        calcWindow.button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"3");
            }
        });
        calcWindow.button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"4");
            }
        });
        calcWindow.button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"5");
            }
        });
        calcWindow.button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"6");
            }
        });
        calcWindow.button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"7");
            }
        });
        calcWindow.button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"8");
            }
        });
        calcWindow.button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"9");
            }
        });
        calcWindow.buttonDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!(calcWindow.display.getText().equals(""))) {
                    calcWindow.display.setText(calcWindow.display.getText().substring(0, calcWindow.display.getText().length() - 1));
                }
            }
        });
        calcWindow.buttonPM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!(calcWindow.display.getText().equals(""))) {
                    if (!(calcWindow.display.getText().substring(0, 1).equals("-"))) {
                        calcWindow.display.setText("-" + calcWindow.display.getText());
                    } else {
                        calcWindow.display.setText(calcWindow.display.getText().replace("-", ""));
                    }
                }
            }
        });
        calcWindow.buttonC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText("");
            }
        });
        calcWindow.buttonRBracket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText() + "(");
            }
        });
        calcWindow.buttonSum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"+");
            }
        });
        calcWindow.buttonSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"-");
            }
        });
        calcWindow.buttonMul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"*");
            }
        });
        calcWindow.buttonDiv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText()+"/");
            }
        });
        calcWindow.buttonLBracket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcWindow.display.setText(calcWindow.display.getText() + ")");
            }
        });
        calcWindow.buttonRes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer fResult;
                String text = calcWindow.display.getText();
                fResult = cache.pop(text);
                if (fResult == null) {
                    Logging.write(userLogin, "The calculation was successful");
                    calcWindow.display.setText(Integer.toString(result(calcWindow.display.getText())));
                    fResult = result(calcWindow.display.getText());
                    cache.push(text,Integer.toString(fResult));
                } else {
                    Logging.write(userLogin, "The value is taken from the cache");
                    calcWindow.display.setText(Integer.toString(fResult));
                }
            }
        });
    }
    //для опредения пробелов
    static boolean isDelim(char c) {
        return (c == ' ');
    }
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }
    //Приоритет операций
    static int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
    static void processOperator(LinkedList<Integer> st, char op) {
        int r = st.removeLast();
        int l = st.removeLast();
        switch (op) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
        }
    }
    public static int result(String s) {
        LinkedList<Integer> st = new LinkedList<Integer>();
        LinkedList<Character> op = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st,op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    operand += s.charAt(i++);
                --i;
                st.add(Integer.parseInt(operand));
            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);
    }
}
