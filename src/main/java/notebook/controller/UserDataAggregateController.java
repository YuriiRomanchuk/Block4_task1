package notebook.controller;

import notebook.enums.Groups;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;

public class UserDataAggregateController<T> {

    public void initializeUserDataModel(T userDataObject, Map<String, String> preparedUserData) {

        for (Map.Entry<String, String> entry : preparedUserData.entrySet()) {
            String fieldName = entry.getKey();
            String fieldValue = entry.getValue();

            try {
                Type fieldType = userDataObject.getClass().getDeclaredField(fieldName).getGenericType();
                Method fieldMethod = userDataObject.getClass().getDeclaredMethod("set" + firstUpperCase(fieldName),
                        receiveClassTypeParameters(fieldType));
                fieldMethod.invoke(userDataObject, typifyFieldValue(fieldValue, fieldType));
            } catch (NoSuchFieldException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private Class receiveClassTypeParameters(Type fieldType) {

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
            try {
                return Groups.valueOf(fieldValue);
            } catch (Exception e) {
                System.out.println(String.format("Invalid group %s! Groups include: ", fieldValue));
                Arrays.stream(Groups.values()).forEach(g -> System.out.println(g.toString()));
                e.printStackTrace();
                return null;
            }
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
