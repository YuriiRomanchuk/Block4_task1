package notebook.initializer;

import notebook.controller.PrepareDataController;
import notebook.controller.UserDataAggregateController;
import notebook.controller.ViewDataController;
import notebook.model.UserDataAddress;
import notebook.rule.UserDataRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDataAddressInitializer {

    private List<UserDataAddress> userDataAddresses = new ArrayList<>();
    private UserDataAggregateController<UserDataAddress> userDataAddressAggregateController = new UserDataAggregateController();
    private PrepareDataController prepareDataController;
    private ViewDataController viewDataController;

    public UserDataAddressInitializer(PrepareDataController prepareDataController, ViewDataController viewDataController) {
        this.prepareDataController = prepareDataController;
        this.viewDataController = viewDataController;
    }

    public List<UserDataAddress> initializeAddress(List<UserDataRule> supplierAddressValidator) {

        boolean continueCreateAddress = true;

        while (continueCreateAddress) {
            UserDataAddress userDataAddress = new UserDataAddress();
            Map<String, String> preparedUserDataAddress = prepareDataController.prepareUserData(supplierAddressValidator);
            userDataAddressAggregateController.initializeUserDataModel(userDataAddress, preparedUserDataAddress);
            userDataAddresses.add(userDataAddress);

            if (!viewDataController.receiveAnswerAboutInputNewAddress()) {
                continueCreateAddress = false;
            }
        }

        return userDataAddresses;
    }
}
