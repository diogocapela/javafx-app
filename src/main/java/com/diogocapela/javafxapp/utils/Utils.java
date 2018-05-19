package com.diogocapela.javafxapp.utils;

import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    private Utils() {

    }

    /**
     * Strings for alert boxes titles.
     */
    public static final String INFORMATION = "Information";
    public static final String ERROR = "Error";

    /**
     * Lists of days of the week and times of the day.
     */
    public static final String[] LIST_OF_DAYS = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"};
    public static final String[] LIST_OF_TIMES = {"00:00", "00:30", "01:00", "01:30", "02:00", "02:30", "03:00", "03:30", "04:00", "04:30", "05:00", "05:30", "06:00", "06:30", "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00", "21:30", "22:00", "22:30", "23:00", "23:30"};

    /**
     * Opens a JavaFX alert box.
     */
    public static void openAlert(String title, String headerText, String contentText, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    /**
     * Returns a string with the current timestamp separated with dashes (-).
     */
    public static String getTimestampString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return sdf.format(timestamp);
    }

    /**
     * Returns the data out of a file in a specific format.
     */
    public static List<ArrayList<String>> getDataFromFile(String filePath) {
        List<ArrayList<String>> data = new ArrayList<>();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] lineData = scanner.nextLine().split(";");
                ArrayList<String> line = new ArrayList<>();
                for (String item : lineData) {
                    line.add(item);
                }
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            Logger.log(e.getMessage());
        }
        return data;
    }

    public static List<String> getFileNamesFromFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        List<String> fileNames = new ArrayList<>();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                fileNames.add(listOfFile.getName());
            } else if (listOfFile.isDirectory()) {
                // do nothing
            }
        }
        return fileNames;
    }

}