package notebook.validators;

import java.util.HashMap;
import java.util.Map;

public class AddressUserDataValidator implements UserDataValidator {

    private static final String regex = "([A-Za-z0-9-]+)";
    private Map<String, Boolean> obligatoryFieldsName = new HashMap<>();

    public AddressUserDataValidator() {
        obligatoryFieldsName.put("index", true);
        obligatoryFieldsName.put("city", true);
        obligatoryFieldsName.put("street", true);
        obligatoryFieldsName.put("houseNumber", true);
        obligatoryFieldsName.put("flatNumber", true);
    }

    public String getRegex() {
        return regex;
    }

    public Map<String, Boolean> getObligatoryFieldsName() {
        return obligatoryFieldsName;
    }
}

