package notebook.controllers;

import java.io.InputStream;
import java.util.Scanner;

public class ViewDataController {

    private static String INPUT_DATA = "Input %s = ";
    private static String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    private static String USER_DATA = "Current user data: \n";
    private static String USER_QUESTION = " %s is not obligatory. Do you want to input value?(1 - yes, 2 or other - no)";
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

    public int receiveAnswerAboutInputValue(String fieldName) {
        printMessage(String.format(USER_QUESTION, fieldName));
        return in.nextInt();
    }

    public String inputStringValue(String fieldName) {

        while (!in.hasNext()) {
            printWrongInputData(fieldName);
        }
        return in.next();
    }

}
