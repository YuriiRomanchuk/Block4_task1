package notebook.initializers;

import notebook.controllers.PrepareDataController;
import notebook.controllers.UserDataAggregateController;
import notebook.controllers.ViewDataController;
import notebook.models.UserDataAddress;
import notebook.validators.UserDataValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class UserDataAddressInitializer {

    private List<UserDataAddress> userDataAddresses = new ArrayList<>();
    private UserDataAggregateController<UserDataAddress> userDataAddressAggregateController = new UserDataAggregateController();
    private PrepareDataController prepareDataController;
    private ViewDataController viewDataController;

    public UserDataAddressInitializer(PrepareDataController prepareDataController, ViewDataController viewDataController) {
        this.prepareDataController = prepareDataController;
        this.viewDataController = viewDataController;
    }

    public List<UserDataAddress> initializeAddress(List<Supplier<UserDataValidator>> supplierAddressValidator) {

        boolean continueCreateAddress = true;

        while (continueCreateAddress) {

            UserDataAddress userDataAddress = new UserDataAddress();

            Map<String, String> preparedUserDataAddress = prepareDataController.prepareUserData(supplierAddressValidator);
            userDataAddressAggregateController.InitializeUserDataModel(userDataAddress, preparedUserDataAddress);
            userDataAddresses.add(userDataAddress);

            if (!viewDataController.receiveAnswerAboutInputNewAddress()) {
                continueCreateAddress = false;
            }
        }

        return userDataAddresses;
    }

}
