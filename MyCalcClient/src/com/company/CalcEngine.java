package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Движок калькулятора
 * Created by Андрей on 26.04.2017.
 */
public class CalcEngine {
    class ClickSetText implements ActionListener {
        private int number;
        ClickSetText (int number) {
            this.number = number;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            calcWindow.display.setText(calcWindow.display.getText()+number);
        }
    }
    CalcWindow calcWindow;
    Cache cache;
    CalcEngine (String userLogin, Socket socket) {
        cache = new Cache();
        calcWindow = new CalcWindow(userLogin);
        calcWindow.setVisible(true);
        calcWindow.button0.addActionListener(new ClickSetText(0));
        calcWindow.button1.addActionListener(new ClickSetText(1));
        calcWindow.button2.addActionListener(new ClickSetText(2));
        calcWindow.button3.addActionListener(new ClickSetText(3));
        calcWindow.button4.addActionListener(new ClickSetText(4));
        calcWindow.button5.addActionListener(new ClickSetText(5));
        calcWindow.button6.addActionListener(new ClickSetText(6));
        calcWindow.button7.addActionListener(new ClickSetText(7));
        calcWindow.button8.addActionListener(new ClickSetText(8));
        calcWindow.button9.addActionListener(new ClickSetText(9));
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
                String text = calcWindow.display.getText();
                Integer fResult;
                String response = "";
                fResult = cache.pop(text);
                try  {
                    if (fResult != null) {
                        response = Integer.toString(fResult);
                        calcWindow.display.setText(response);
                    }
                    DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                    //говорим серверу что необходимо произвести вычисления
                    outputStream.writeInt(0);
                    outputStream.flush();
                    outputStream.flush();
                    outputStream.writeUTF(text);
                    outputStream.flush();
                    DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                    response = inputStream.readUTF();
                    if (fResult == null) {
                        cache.push(text, response);
                    }
                    calcWindow.display.setText(response);
                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
