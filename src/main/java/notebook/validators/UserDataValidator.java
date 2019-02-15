package notebook.validators;

import java.util.List;

public interface UserDataValidator {

    String regex = "";
    List<String> fieldsName = null;

    List<String> getFieldsName();

    String getRegex();
}
