package notebook.rule;

import java.util.HashMap;
import java.util.Map;

public class StringUserDataRuler implements UserDataRule {

    private final String regex = "([A-Za-zа-яА-ЯїЇєЄіІ]+)";
    private Map<String, Boolean> obligatoryFieldsName = new HashMap<>();

    public StringUserDataRuler() {
        obligatoryFieldsName.put("lastName", true);
        obligatoryFieldsName.put("firstName", true);
        obligatoryFieldsName.put("middleName", true);
    }

    public String getRegex() {
        return regex;
    }

    public Map<String, Boolean> getObligatoryFieldsName() {
        return obligatoryFieldsName;
    }
}
