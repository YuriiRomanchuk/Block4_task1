package notebook.validators;

import java.util.List;
import java.util.Map;

public interface UserDataValidator {

    String regex = "";
    Map<String, Boolean> obligatoryFieldsName = null;

    Map<String, Boolean> getObligatoryFieldsName();

    String getRegex();
}
