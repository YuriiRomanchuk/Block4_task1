package notebook;

import notebook.controller.ViewDataController;
import notebook.initializer.UserDataModelInitializer;

public class MainClass {

    public static void main(String[] args) {

        AccessPoint accessPoint = new AccessPoint(new UserDataModelInitializer(), new ViewDataController(System.in));
        accessPoint.startProgram();

    }
}
