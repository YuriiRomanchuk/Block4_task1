package notebook.validators;

import java.util.HashMap;
import java.util.Map;

public class NumberUserDataValidator implements UserDataValidator {

    private static final String regex = "^((8|\\+3)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    private Map<String, Boolean> obligatoryFieldsName = new HashMap<>();

    public NumberUserDataValidator() {
        obligatoryFieldsName.put("homePhoneNumber", true);
        obligatoryFieldsName.put("mobilePhoneNumber", true);
        obligatoryFieldsName.put("mobilePhoneNumberSecond", false);
    }

    public String getRegex() {
        return regex;
    }

    public Map<String, Boolean> getObligatoryFieldsName() {
        return obligatoryFieldsName;
    }
}
