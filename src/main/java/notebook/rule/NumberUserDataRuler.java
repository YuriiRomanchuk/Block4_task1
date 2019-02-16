package notebook.rule;

import java.util.HashMap;
import java.util.Map;

public class NumberUserDataRuler implements UserDataRule {

    private static final String regex = "^((8|\\+3)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
    private Map<String, Boolean> obligatoryFieldsName = new HashMap<>();

    public NumberUserDataRuler() {
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
