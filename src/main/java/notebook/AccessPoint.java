package notebook;

import notebook.controllers.PrepareDataController;
import notebook.controllers.ViewDataController;
import notebook.model.UserDataModel;
import notebook.model.UserDataModelInitializer;
import notebook.validators.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class AccessPoint {


    private UserDataModelInitializer userDataModelInitializer;
    private ViewDataController viewDataController;
    PrepareDataController prepareDataController;

    public AccessPoint(UserDataModelInitializer userDataModelInitializer, ViewDataController viewDataController) {
        this.userDataModelInitializer = userDataModelInitializer;
        this.viewDataController = viewDataController;
        prepareDataController = new PrepareDataController(viewDataController);
    }

    public void startProgram() {

        Map<String, String> preparedUserData = prepareDataController.prepareUserData(receiveValidators());
        UserDataModel userDataModel = userDataModelInitializer.InitializeUserDataModel(preparedUserData);
        viewDataController.printAllUserData(userDataModel.toString());

    }

    private List<Supplier<UserDataValidator>> receiveValidators() {

        List<Supplier<UserDataValidator>> supplierValidators = new ArrayList<>();
        supplierValidators.add(StringUserDataValidator::new);
        supplierValidators.add(StringNumberUserDataValidator::new);
        supplierValidators.add(NumberUserDataValidator::new);
        supplierValidators.add(EmailUserDataValidator::new);

        return supplierValidators;
    }

}
