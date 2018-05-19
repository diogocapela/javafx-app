package com.diogocapela.javafxapp.utils;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logger {

    private static String LOG_FILE_PATH = "./src/main/resources/database/logs.txt";

    private Logger() {

    }

    public static void log(String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String log = sdf.format(timestamp) + " - " + message;
        System.out.println(log);
        writeToLogFile(log);
    }

    public static void writeToLogFile(String log) {
        try {
            File file = new File(LOG_FILE_PATH);
            file.createNewFile(); // if file already exists will do nothing
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String result = "";
            String line;
            while ((line = br.readLine()) != null) {
                result = String.format("%s%n%s", result, line);
            }
            result = log + result;
            file.delete();
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(result.getBytes());
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> getLogFileData() {
        List<String> logData = new ArrayList<>();
        File file = new File(LOG_FILE_PATH);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                logData.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return logData;
    }

}
