package notebook.validators;

import java.util.ArrayList;
import java.util.List;

public class StringNumberUserDataValidator implements UserDataValidator{

    private static final String regex = "([A-Za-z0-9-]+)";
    private List<String> fieldsName = new ArrayList<>();

    public StringNumberUserDataValidator() {
        fieldsName.add("nickname");
        fieldsName.add("comment");
        fieldsName.add("groupName");
        fieldsName.add("skype");
    }

    public String getRegex() {
        return regex;
    }

    public List<String> getFieldsName() {
        return fieldsName;
    }
}

