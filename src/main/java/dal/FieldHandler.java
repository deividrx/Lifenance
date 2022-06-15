package dal;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;
import org.apache.commons.lang3.math.NumberUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FieldHandler {

    private final Class<?> cls;

    public FieldHandler(Class<?> cls) throws NullPointerException {
        this.cls = Objects.requireNonNull(cls);
    }

    private String getFieldValue(Field field, Object obj) throws IllegalAccessException {
        if (!field.get(obj).getClass().getPackage().getName().equals("models")) {
            String text = field.get(obj).toString();

            if (text.isBlank() || text.isBlank()) return null;

            if (!NumberUtils.isCreatable(text)) {
                return "'" + text + "'";
            } else {
                return text;
            }
        } else {
            FieldHandler fh = new FieldHandler(field.getType());
            return fh.getPrimaryKeyValue(field.get(obj));
        }
    }

    public String getPrimaryKeyName() {
        String name = null;
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                name = field.getDeclaredAnnotation(PrimaryKey.class).value();
            }
        }
        return name;
    }

    public String getPrimaryKeyValue(Object object) throws IllegalAccessException {
        String primaryKey = null;
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                primaryKey = getFieldValue(field, object);
            }
        }
        return primaryKey;
    }

    public Map<String, String> getColumns(Object object) throws IllegalAccessException {
        Map<String, String> map = new HashMap<>();
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(ColumnName.class)) {
                String name = field.getDeclaredAnnotation(ColumnName.class).value();
                String value = getFieldValue(field, object);
                map.put(name, value);
            }
        }
        return map;
    }
}
