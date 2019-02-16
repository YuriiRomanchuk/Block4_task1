package notebook.controller;

import notebook.rule.UserDataRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrepareDataController {

    private ViewDataController viewDataController;

    public PrepareDataController(ViewDataController viewDataController) {
        this.viewDataController = viewDataController;
    }

    public Map<String, String> prepareUserData(List<UserDataRule> supplierValidator) {

        Map<String, String> userData = new HashMap<>();

        for (UserDataRule userDataRule : supplierValidator) {
            for (Map.Entry<String, Boolean> entry : userDataRule.getObligatoryFieldsName().entrySet()) {
                String fieldName = entry.getKey();
                Boolean obligatoryField = entry.getValue();

                if (inputNonObligatoryField(obligatoryField, fieldName)) {
                    userData.put(fieldName, validateInputValue(fieldName, userDataRule.getRegex()));
                }
            }
        }
        return userData;
    }

    private String validateInputValue(String fieldName, String regex) {

        viewDataController.printInputFieldData(fieldName);

        boolean correctValue = false;
        StringBuilder fieldData = new StringBuilder();

        while (!correctValue) {
            fieldData.append(viewDataController.inputStringValue(fieldName));
            correctValue = fieldData.toString().matches(regex);
            if (!correctValue) {
                fieldData.setLength(0);
                viewDataController.printWrongInputData(fieldName);
            }
        }

        return fieldData.toString();
    }

    private boolean inputNonObligatoryField(boolean obligatoryField, String fieldName) {
        if (!obligatoryField) {
            return viewDataController.receiveAnswerAboutInputValue(fieldName);
        }
        return true;
    }
}
