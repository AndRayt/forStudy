package com.company;

import java.io.*;
import java.net.*;
import java.util.LinkedList;

/**
 * Многопоточный сервер
 */
public class Server {

    private ServerSocket server;
    private int port = 9999;

    public Server() {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("error");
        }
    }

    public static void main(String[] args) {
        Server myServer = new Server();
        myServer.handleConnection();
    }

    public void handleConnection() {
        System.out.println("Waiting client");
        while (true) {
            try {
                Socket socket = server.accept();
                new ConnectionHandler(socket);
            } catch (IOException e) {
                System.err.println("IOException");
            }
        }
    }
}

class ConnectionHandler implements Runnable {

    private Socket socket;
    private String loginU;
    private Cache cache;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        cache = new Cache();
        try {
            try (DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                 DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {
                while(true) {
                    int numOfMov = inputStream.readInt();
                    //Вычисления
                    if (numOfMov == 0) {
                        String text = inputStream.readUTF();
                        String resultS = "";
                        Integer fResult;
                        fResult = cache.pop(text);
                        if (fResult == null) {
                            Logging.write(loginU, "The calculation was successful");
                            resultS = Integer.toString(result(text));
                            //fResult = result(resultS);
                            cache.push(text, resultS);
                        } else {
                            Logging.write(loginU, "The value is taken from the cache");
                            resultS = Integer.toString(fResult);
                        }
                        outputStream.writeUTF(resultS);
                        outputStream.flush();
                    }
                    //Регистрация
                    if (numOfMov == 1) {
                        String login = inputStream.readUTF();
                        String password = inputStream.readUTF();
                        wrFile.update("userLogin.doc", login + "@" + password);
                    }
                    //Авторизация
                    if (numOfMov == 2) {
                        String login = inputStream.readUTF();
                        String password = inputStream.readUTF();
                        String fieldText = login + "@" + password;
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
                            //Авторизация прошла успешно
                            loginU = inLogin;
                            Logging.write(loginU,"Enter to calculator");
                            outputStream.writeUTF(inLogin);
                            outputStream.flush();
                        } else {
                            //Неверный логин или пароль
                            outputStream.writeUTF("UNKNOWN");
                            outputStream.flush();
                            Logging.write("SYSTEM WARNING","Incorrect login / password entered");
                        }
                    }
                }
            } catch (EOFException e) {
                // client closed connection
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
