package notebook.validators;

import java.util.List;

public class StringNumberUserdataValidator {

    private static final String regex = "([A-Za-z0-9-]+)";
    private List<String> fieldsName;

    public StringNumberUserdataValidator() {
        fieldsName.add("nickname");
        fieldsName.add("comment");
        fieldsName.add("groupName");
        fieldsName.add("skype");
    }
}

