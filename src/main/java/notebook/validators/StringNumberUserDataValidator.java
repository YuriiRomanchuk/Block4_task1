package notebook.validators;

import java.util.HashMap;
import java.util.Map;

public class StringNumberUserDataValidator implements UserDataValidator {

    private static final String regex = "([A-Za-z0-9-]+)";
    private Map<String, Boolean> obligatoryFieldsName = new HashMap<>();

    public StringNumberUserDataValidator() {
        obligatoryFieldsName.put("nickname", true);
        obligatoryFieldsName.put("comment", true);
        obligatoryFieldsName.put("groupName", true);
        obligatoryFieldsName.put("skype", true);
    }

    public String getRegex() {
        return regex;
    }

    public Map<String, Boolean> getObligatoryFieldsName() {
        return obligatoryFieldsName;
    }
}

