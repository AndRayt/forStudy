package com.company;

import javax.swing.*;
import java.net.Socket;

/**
 * Класс с которого начинает работу клиент
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //CalcEngine calc = new CalcEngine("TEST");
        Socket socket = new Socket("localhost", 9999);
        JFrame myWindow = new Login(socket);
        myWindow.setVisible(true);
    }
}