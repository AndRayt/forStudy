package com.company;
import java.io.*;
/**
 * Чтение из файла
 * Created by Андрей on 21.04.2017.
 */
public class wrFile {
    static File file;
    public static synchronized void write(String fileName, String text) {
        file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileOutputStream(file),true);
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void update(String fileName, String text) {
        String result = "";
        try (FileReader fl = new FileReader(fileName)) {
            BufferedReader in = new BufferedReader(fl);
            String lineText = "";
            while ((lineText = in.readLine()) != null) {
                result += lineText;
                result += "\n";
            }
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }
        result += text;
        write(fileName, result);
    }

    public static synchronized void rename(String fileName, String newFileName) {
        file = new File(fileName);
        if(file.exists()){
            File newFile = new File(newFileName);
            System.out.println(file.renameTo(newFile));
        }
        else{
            System.err.println("File not found!");
        }
    }

    public static synchronized int countRecord(String fileName) {
        int result = 0;
        try (FileReader fl1 = new FileReader(fileName)) {
            BufferedReader in1 = new BufferedReader(fl1);
            while ((in1.readLine()) != null) {
                result++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
