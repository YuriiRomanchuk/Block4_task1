package notebook;

import notebook.controllers.ViewDataController;
import notebook.model.UserDataModel;
import notebook.model.UserDataModelInitializer;

public class MainClass {

    public static void main(String[] args) {

        AccessPoint accessPoint = new AccessPoint(new UserDataModelInitializer(), new ViewDataController(System.in));
        accessPoint.startProgram();

    }
}
