package notebook.validators;

import java.util.ArrayList;
import java.util.List;

public class NumberUserDataValidator implements UserDataValidator {

    private static final String regex = "([0-9]+)";
    private List<String> fieldsName = new ArrayList<>();

    public NumberUserDataValidator() {
        fieldsName.add("homePhoneNumber");
        fieldsName.add("mobilePhoneNumber");
        fieldsName.add("mobilePhoneNumberSecond");
    }

    public String getRegex() {
        return regex;
    }

    public List<String> getFieldsName() {
        return fieldsName;
    }
}
