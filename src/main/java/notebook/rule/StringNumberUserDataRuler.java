package notebook.rule;

import java.util.HashMap;
import java.util.Map;

public class StringNumberUserDataRuler implements UserDataRule {

    private static final String regex = "([A-Za-zа-яА-ЯїЇєЄіІ0-9]+)";
    private Map<String, Boolean> obligatoryFieldsName = new HashMap<>();

    public StringNumberUserDataRuler() {
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

