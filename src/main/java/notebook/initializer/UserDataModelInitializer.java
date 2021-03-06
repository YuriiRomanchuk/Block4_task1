package notebook.initializer;

import notebook.controller.UserDataAggregateController;
import notebook.model.UserDataAddress;
import notebook.model.UserDataModel;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserDataModelInitializer {

    public UserDataModel InitializeUserDataModel(Map<String, String> preparedUserData, List<UserDataAddress> userDataAddresses) {

        UserDataModel userDataModel = new UserDataModel();
        UserDataAggregateController<UserDataModel> userDataModelAggregateController = new UserDataAggregateController<>();
        userDataModelAggregateController.initializeUserDataModel(userDataModel, preparedUserData);
        userDataModel.setUserDataAddresses(userDataAddresses);
        userDataModel.setFullName(userDataModel.getLastName() + " " + userDataModel.getFirstName() + " " + userDataModel.getMiddleName());

        Date date = new Date();
        userDataModel.setEntryDate(date.toString());
        userDataModel.setDateOfLastChange(date.toString());

        return userDataModel;
    }
}
