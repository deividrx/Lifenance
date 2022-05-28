package dal;

import models.annotations.ColumnName;
import models.annotations.TableId;
import org.apache.commons.lang3.math.NumberUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericDao<T> {

    private final String tableName;
    private final Connection connection;
    private final Class<T> cls;

    public GenericDao(String tableName, Class<T> cls) {
        this.cls = cls;
        this.tableName = tableName;
        connection = ConnectionDb.getConnection();
    }

    private String getAnnotationValue(Field field) {
        return field.getDeclaredAnnotation(ColumnName.class).value();
    }

    private String getFieldValue(Field field, Object obj) throws IllegalAccessException {
        String text = field.get(obj).toString();
        if (!NumberUtils.isCreatable(text)) {
                return "'" + text + "'";
        } else {
            return text;
        }
    }

    public void insert(Object object) {
        try {
            Class<?> cls = Objects.requireNonNull(object).getClass();
            ArrayList<String> columnValues = new ArrayList<>();
            ArrayList<String> columnNames = new ArrayList<>();

            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(ColumnName.class)) {
                    columnNames.add(getAnnotationValue(field));
                    columnValues.add(getFieldValue(field, object));
                }
            }

            String sql = "INSERT INTO " + tableName + " (" + String.join(", ", columnNames) + ") "
                    + "VALUES (" + String.join(", ", columnValues) + ")";
            System.out.println(sql);
            connection.prepareStatement(sql).execute();

        } catch (SQLException | IllegalAccessException error) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, error);
        }
    }

    public void removeById(Long id) {
        try {
            String sql = "DELETE FROM " + tableName + " WHERE id_" + tableName + "= ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<T> listing() {
        ArrayList<T> arrayObj = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + tableName + " ORDER BY id_" + tableName + " ASC";
            System.out.println(sql);
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnNum = rsmd.getColumnCount();
            while (rs.next()) {
                ArrayList<String> data = new ArrayList<>();

                for (int i = 1; i <= columnNum; i++) {
                    data.add(rs.getObject(i).toString());
                }

                String args = (String.join(";", data));
                arrayObj.add(cls.getDeclaredConstructor(String.class).newInstance(args));
            }
        } catch (SQLException | NoSuchMethodException ex) {
            Logger.getLogger(ConnectionDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
        return arrayObj;
    }

    public void update(Object obj) {
        try {
            Class<?> cls = Objects.requireNonNull(obj).getClass();
            ArrayList<String> updateArray = new ArrayList<>();
            ArrayList<String> arrayWhere = new ArrayList<>();
            String id = null;

            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(TableId.class)) {
                    id = field.get(obj).toString();
                }

                if (field.isAnnotationPresent(ColumnName.class)) {
                    updateArray.add(getAnnotationValue(field) + " = " + getFieldValue(field, obj));
                }
            }

            String sql = "UPDATE " + tableName + " SET "+ String.join(",", updateArray) +" WHERE id_"
                    + tableName + " = " + id;
            System.out.println(sql);
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException | IllegalAccessException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}