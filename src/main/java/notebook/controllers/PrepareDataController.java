package notebook.controllers;

import notebook.validators.UserDataValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class PrepareDataController {

    private ViewDataController viewDataController;

    public PrepareDataController(ViewDataController viewDataController) {
        this.viewDataController = viewDataController;
    }

    public Map<String, String> prepareUserData(List<Supplier<UserDataValidator>> supplierValidator) {

        Map<String, String> userData = new HashMap<>();

        for (Supplier<UserDataValidator> userDataValidatorSupplier : supplierValidator) {
            UserDataValidator userDataValidator = userDataValidatorSupplier.get();
            for (Map.Entry<String, Boolean> entry : userDataValidator.getObligatoryFieldsName().entrySet()) {
                String fieldName = entry.getKey();
                Boolean obligatoryField = entry.getValue();
                userData.put(fieldName, ValidateInputValue(fieldName, userDataValidator.getRegex(), obligatoryField));
            }
        }
        return userData;
    }

    private String ValidateInputValue(String fieldName, String regex, boolean obligatoryField) {

        viewDataController.printInputFieldData(fieldName);

        boolean correctValue = false;
        StringBuilder fieldData = new StringBuilder();

        while (!correctValue) {
            fieldData.append(viewDataController.inputStringValue(fieldName));
            correctValue = obligatoryField ? fieldData.toString().matches(regex) : true;
            if (!correctValue) {
                fieldData.setLength(0);
                viewDataController.printWrongInputData(fieldName);
            }
        }

        return fieldData.toString();
    }

}
