package dal;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericDao<T> {

    private final String tableName;
    private final Connection connection;
    private final FieldHandler fieldHandler;
    private final String primaryKeyName;
    private final Class<T> cls;

    public GenericDao(String tableName, Class<T> cls) {
        this.tableName = tableName;
        this.cls = cls;
        fieldHandler = new FieldHandler(cls);
        primaryKeyName = fieldHandler.getPrimaryKeyName();
        connection = ConnectionDb.getConnection();
    }

    public void insert(Object object) {
        try {
            Map<String, String> columns = fieldHandler.getColumns(object);
            String sql = "INSERT INTO " + tableName + " (" + String.join(", ", columns.keySet()) + ") "
                    + "VALUES (" + String.join(", ", columns.values()) + ")";
            System.out.println(sql);
            connection.prepareStatement(sql).execute();

        } catch (SQLException | IllegalAccessException error) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, error);
        }
    }

    public void remove(Long id) {
        try {
            String sql = "DELETE FROM " + tableName + " WHERE " + primaryKeyName + "= ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<T> getList() {
        ArrayList<T> arrayObj = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + tableName + " ORDER BY " + primaryKeyName + " ASC";
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
        } catch (SQLException | NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                 InstantiationException ex) {
            Logger.getLogger(ConnectionDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayObj;
    }

    public void update(Object obj) {
        try {
            String primaryKeyValue = fieldHandler.getPrimaryKeyValue(obj);
            Map<String, String> columns = fieldHandler.getColumns(obj);

            String sql = "UPDATE " + tableName + " SET "+ String.join(",", columns.values()) +" WHERE "
                    + primaryKeyName + " = " + primaryKeyValue;

            System.out.println(sql);
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException | IllegalAccessException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public T get(Long id) {
        try {
            String sql = "SELECT * FROM " + tableName + " WHERE " + primaryKeyName + " = " + id;
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            ArrayList<String> data = new ArrayList<>();
            int columnNum = rsmd.getColumnCount();

            for (int i = 1; i <= columnNum; i++) {
                data.add(rs.getObject(i).toString());
            }

            String args = (String.join(";", data));
            return cls.getDeclaredConstructor(String.class).newInstance(args);

        } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException
                | NoSuchMethodException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}