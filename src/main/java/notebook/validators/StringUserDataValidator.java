package notebook.validators;

import java.util.ArrayList;
import java.util.List;

public class StringUserDataValidator implements UserDataValidator {

    private final String regex = "([A-Za-z]+)";
    private List<String> fieldsName = new ArrayList<>();

    public StringUserDataValidator() {
        fieldsName.add("lastName");
        fieldsName.add("firstName");
        fieldsName.add("middleName");
    }

    public String getRegex() {
        return regex;
    }

    public List<String> getFieldsName() {
        return fieldsName;
    }
}
