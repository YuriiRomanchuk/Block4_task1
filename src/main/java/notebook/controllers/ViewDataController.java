package notebook;

import java.io.InputStream;
import java.util.Scanner;

public class ViewDataController {

    private static final String INPUT_DATA = "Input %s = ";
    private static final String WRONG_INPUT_DATA = "Wrong input! Repeat please! ";
    private static final String CURRENT_RANGE = "Current range: %s to %s ";
    private static final String RECEIVE_ABOUT_CONTINUE_PROGRAM = "Do you want to continue game?(1 - Yes, 2 or other - No)";
    private static final String RECEIVE_ANSWER_ABOUT_RANGE = "Do you want to change %s value or set default of range? (1 - Yes, 2 or other - No)";
    private static final String USER_WIN = "You win!";
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

    public String inputStringValue(String fieldName) {

        while (! in.hasNext()) {
            printWrongInputData(fieldName);
        }

        return in.next();
    }

}
