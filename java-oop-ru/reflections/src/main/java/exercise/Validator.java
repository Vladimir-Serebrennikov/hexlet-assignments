package exercise;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    public static List<String> validate(Object object) {
        List<String> invalidFields = new ArrayList<>();
        Class<?> clazz = object.getClass();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == NotNull.class) {
                    field.setAccessible(true);
                    try {
                        if (field.get(object) == null) {
                            invalidFields.add(field.getName());
                        }

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return invalidFields;
    }

    public static Map<String, List<String>> advancedValidate(Object object) {
        Map<String, List<String>> invalidFields = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            // Проверяем наличие аннотации @NotNull
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(object) == null) {
                        // Поле помечено @NotNull и имеет значение null
                        invalidFields.computeIfAbsent(field.getName(), k -> new ArrayList<>()).add("can not be null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            // Проверяем наличие аннотации @MinLength
            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength annotation = field.getAnnotation(MinLength.class);
                try {
                    field.setAccessible(true);
                    String value = (String) field.get(object);
                    if (value != null && value.length() < annotation.minLength()) {
                        // Поле имеет длину меньше, чем задано в аннотации @MinLength
                        invalidFields.computeIfAbsent(field.getName(), k -> new ArrayList<>())
                                .add("length less than " + annotation.minLength());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return invalidFields;
    }

    public static void main(String[] args) {
        Address address = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> notValidFields = Validator.advancedValidate(address);
        System.out.println(notValidFields);

    }


}
