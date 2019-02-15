package notebook.validators;

import java.util.List;

public class StringDataUserValidator {

    private static final String regex = "([A-Za-z])";
    private List<String> fieldsName;

    public StringDataUserValidator() {
        fieldsName.add("lastName");
        fieldsName.add("firstName");
        fieldsName.add("middleName");
    }
}
