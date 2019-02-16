package notebook.rule;

import java.util.HashMap;
import java.util.Map;

public class EmailUserDataRule implements UserDataRule {

    private final String regex = "\\w+@[a-zA-Z]+?\\.[a-zA-Z]{2,6}";
    private Map<String, Boolean> obligatoryFieldsName = new HashMap<>();

    public EmailUserDataRule() {
        obligatoryFieldsName.put("email", true);
    }

    public String getRegex() {
        return regex;
    }

    public Map<String, Boolean> getObligatoryFieldsName() {
        return obligatoryFieldsName;
    }
}
