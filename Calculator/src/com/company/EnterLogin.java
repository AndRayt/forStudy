package com.company;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Вход
 * Created by Андрей on 12.04.2017.
 */

public class EnterLogin extends JFrame{
    MD5 md5;
    JTextField loginField;
    JTextField passwordField;
    EnterLogin(String title) {
        super(title);
        md5= new MD5();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    // Настраиваем первую горизонтальную панель (для ввода логина)
        Box box1 = Box.createHorizontalBox();
        JLabel loginLabel = new JLabel("Логин:");
        loginField = new JTextField(15);
        box1.add(loginLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(loginField);
    // Настраиваем вторую горизонтальную панель (для ввода пароля)
        Box box2 = Box.createHorizontalBox();
        JLabel passwordLabel = new JLabel("Пароль:");
        passwordField = new JPasswordField(15);
        box2.add(passwordLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(passwordField);
    // Настраиваем третью горизонтальную панель (с кнопками)
        Box box3 = Box.createHorizontalBox();
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Отмена");
        box3.add(Box.createHorizontalGlue());
        box3.add(ok);
        box3.add(Box.createHorizontalStrut(12));
        box3.add(cancel);
    // Уточняем размеры компонентов
        loginLabel.setPreferredSize(passwordLabel.getPreferredSize());
    // Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12,12,12,12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box3);
        setContentPane(mainBox);
        pack();
        setResizable(false);
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Закрытие окна
                setVisible(false);
                dispose();
            }
        });
        //Регистрация нового пользователя
        if (title.equals("Регистрация")) {
            ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    wrFile.update("userLogin.doc", loginField.getText() + "@" + md5.getHash(passwordField.getText()));
                    //Закрытие окна
                    setVisible(false);
                    dispose();
                }
            });
        }
        //Вход
        if (title.equals("Вход")) {
            ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String fieldText = loginField.getText() + "@" + md5.getHash(passwordField.getText());
                    String inLogin = "UNKNOWN";
                    try {
                        FileReader fl = new FileReader("userLogin.doc");
                        int c;
                        String lineText;
                        StringBuffer memoryLogin = new StringBuffer(50);
                        BufferedReader in = new BufferedReader(fl);
                        while ((lineText = in.readLine()) != null) {
                            if (fieldText.equals(lineText)) {
                                char[] lineTextArray = lineText.toCharArray();
                                for (int i = 0; i < lineTextArray.length; i++) {
                                    if (lineTextArray[i] != '@') {
                                        memoryLogin.append(lineTextArray[i]);
                                    } else {
                                        break;
                                    }
                                }
                                inLogin = memoryLogin.toString();
                                break;
                            }
                        }
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    if (!inLogin.equals("UNKNOWN")) {
                        //Закрытие окна
                        setVisible(false);
                        dispose();
                        CalcEngine calc = new CalcEngine(inLogin);
                    } else {
                        Logging.write("SYSTEM WARNING","Incorrect login / password entered");
                    }
                }
            });
        }
    }
}
