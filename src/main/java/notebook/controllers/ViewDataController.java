package notebook.controllers;

import java.io.InputStream;
import java.util.Scanner;

public class ViewDataController {

    private static final String INPUT_DATA = "Input %s = ";
    private static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    private static final String USER_DATA = "Current user data: \n";
    private Scanner in;

    public ViewDataController(InputStream in) {
        this.in = new Scanner(in);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    public void printInputFieldData(String fieldName) {
        printMessage(String.format(INPUT_DATA, fieldName));
    }

    public void printWrongInputData(String fieldName) {
        printMessage(WRONG_INPUT_DATA + String.format(INPUT_DATA, fieldName));
    }

    public void printAllUserData(String userData) {
        printMessage(USER_DATA + userData);
    }

    public String inputStringValue(String fieldName) {

        while (!in.hasNext()) {
            printWrongInputData(fieldName);
        }
        return in.next();
    }

}
