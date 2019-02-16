package notebook.rule;

import java.util.HashMap;
import java.util.Map;

public class AddressUserDataRule implements UserDataRule {

    private static final String regex = "([A-Za-zа-яА-ЯїЇєЄіІ0-9]+)";
    private Map<String, Boolean> obligatoryFieldsName = new HashMap<>();

    public AddressUserDataRule() {
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

