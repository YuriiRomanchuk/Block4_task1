package notebook.validators;

import java.util.ArrayList;
import java.util.List;

public class EmailUserDataValidator implements UserDataValidator {

    private final String regex = "(\\w+@[a-zA-Z]+?\\.[a-zA-Z]{2,6})";
    private List<String> fieldsName = new ArrayList<>();

    public EmailUserDataValidator() {
        fieldsName.add("email");
    }

    public String getRegex() {
        return regex;
    }

    public List<String> getFieldsName() {
        return fieldsName;
    }
}
