package notebook.validators;

import java.util.List;

public class NumberDataUserValidator {

    private static final String regex = "([0-9])";
    private List<String> fieldsName;

    public NumberDataUserValidator() {
        fieldsName.add("homePhoneNumber");
        fieldsName.add("mobilePhoneNumber");
        fieldsName.add("mobilePhoneNumberSecond");
    }


}
