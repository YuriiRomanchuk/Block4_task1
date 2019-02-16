package notebook;

import notebook.controllers.PrepareDataController;
import notebook.controllers.ViewDataController;
import notebook.initializers.UserDataAddressInitializer;
import notebook.initializers.UserDataModelInitializer;
import notebook.models.UserDataAddress;
import notebook.models.UserDataModel;
import notebook.validators.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

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

    private List<Supplier<UserDataValidator>> receiveMainValidators() {

        List<Supplier<UserDataValidator>> supplierValidators = new ArrayList<>();
        supplierValidators.add(StringUserDataValidator::new);
        supplierValidators.add(StringNumberUserDataValidator::new);
        supplierValidators.add(NumberUserDataValidator::new);
        supplierValidators.add(EmailUserDataValidator::new);

        return supplierValidators;
    }

    private List<Supplier<UserDataValidator>> receiveAddressValidators() {
        List<Supplier<UserDataValidator>> supplierAddressValidator = new ArrayList<>();
        supplierAddressValidator.add(AddressUserDataValidator::new);
        return supplierAddressValidator;
    }

}
