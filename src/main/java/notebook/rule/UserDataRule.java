package notebook.rule;

import java.util.Map;

public interface UserDataRule {

    String regex = "";
    Map<String, Boolean> obligatoryFieldsName = null;

    Map<String, Boolean> getObligatoryFieldsName();

    String getRegex();
}
