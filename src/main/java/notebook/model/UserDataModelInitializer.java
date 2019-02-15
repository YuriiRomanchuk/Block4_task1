package notebook.model;

import notebook.enums.Groups;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

public class UserDataModelInitializer {

    public UserDataModel InitializeUserDataModel(Map<String, String> preparedUserData) {

        UserDataModel userDataModel = new UserDataModel();
        Class<? extends UserDataModel> userDataModelClass = userDataModel.getClass();

        for (Map.Entry<String, String> entry : preparedUserData.entrySet()) {
            String fieldName = entry.getKey();
            String fieldValue = entry.getValue();

            try {
                Type fieldType = userDataModel.getClass().getDeclaredField(fieldName).getGenericType();
                Method fieldMethod = userDataModelClass.getDeclaredMethod("set" + firstUpperCase(fieldName),
                        receiveClassTypeParametrs(fieldValue, fieldType));
                fieldMethod.invoke(userDataModel, typifyFieldValue(fieldValue, fieldType));
            } catch (NoSuchFieldException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        return userDataModel;
    }

    private Class receiveClassTypeParametrs(String fieldValue, Type fieldType) {

        if (fieldType.equals(Integer.class)) {
            return Integer.class;
        } else if (fieldType.equals(Groups.class)) {
            return Groups.class;
        }

        return String.class;
    }

    private Object typifyFieldValue(String fieldValue, Type fieldType) {

        if (fieldType.equals(Integer.class)) {
            return Integer.valueOf(fieldValue);
        } else if (fieldType.equals(Groups.class)) {
            return Groups.valueOf(fieldValue);
        }

        return fieldValue;
    }


    private String firstUpperCase(String word) {

        if (word == null || word.isEmpty()) {
            return word;
        }

        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

}
