package notebook;

import notebook.controller.PrepareDataController;
import notebook.controller.ViewDataController;
import notebook.initializer.UserDataAddressInitializer;
import notebook.initializer.UserDataModelInitializer;
import notebook.model.UserDataAddress;
import notebook.model.UserDataModel;
import notebook.rule.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccessPoint {

    private UserDataModelInitializer userDataModelInitializer;
    private ViewDataController viewDataController;
    PrepareDataController prepareDataController;
    UserDataAddressInitializer userDataAddressInitializer;

    public AccessPoint(UserDataModelInitializer userDataModelInitializer, ViewDataController viewDataController) {
        this.userDataModelInitializer = userDataModelInitializer;
        this.viewDataController = viewDataController;
        prepareDataController = new PrepareDataController(viewDataController);
        userDataAddressInitializer = new UserDataAddressInitializer(prepareDataController, viewDataController);
    }

    public void startProgram() {

        Map<String, String> preparedMainUserData = prepareDataController.prepareUserData(receiveMainValidators());
        List<UserDataAddress> userDataAddresses = userDataAddressInitializer.initializeAddress(receiveAddressValidators());
        UserDataModel userDataModel = userDataModelInitializer.InitializeUserDataModel(preparedMainUserData, userDataAddresses);
        viewDataController.printAllUserData(userDataModel.toString());

    }

    private List<UserDataRule> receiveMainValidators() {

        List<UserDataRule> supplierValidators = new ArrayList<>();
        supplierValidators.add(new StringUserDataRuler());
        supplierValidators.add(new StringNumberUserDataRuler());
        supplierValidators.add(new NumberUserDataRuler());
        supplierValidators.add(new EmailUserDataRule());

        return supplierValidators;
    }

    private List<UserDataRule> receiveAddressValidators() {
        List<UserDataRule> supplierAddressValidator = new ArrayList<>();
        supplierAddressValidator.add(new AddressUserDataRule());
        return supplierAddressValidator;
    }

}
