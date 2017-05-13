package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.WindowAdapter;

/**
 * Окно входа и регистрации
 * Created by Андрей on 12.04.2017.
 */

public class Login extends JFrame {
    JPanel panel = new JPanel();
    JButton log = new JButton("Вход");
    JButton reg = new JButton("Регистрация");

    Login(Socket socket) {
        super("Вход");
        panel.setLayout(new GridLayout(2,1));
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.add(log);
        panel.add(reg);
        this.addWindowListener(new WindowAdapter() {
            public void windowsClosing(WindowEvent e) throws IOException {
                socket.close();
                System.exit(0);
            }
        });
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame loginWindow = new EnterLogin("Вход", socket);
                loginWindow.setVisible(true);
            }
        });
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame loginWindow = new EnterLogin("Регистрация", socket);
                loginWindow.setVisible(true);
            }
        });
        setContentPane(panel);
        setBounds(300, 300, 300, 300);
    }
}
