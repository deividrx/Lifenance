package br.com.lifenance.dal;

import org.apache.logging.log4j.LogManager;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenericDao<T> {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(GenericDao.class);

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

    public long insertReturnId(Object object) {
        try {
            Map<String, String> columns = fieldHandler.getColumns(object);
            String sql = "INSERT INTO " + tableName + " (" + String.join(", ", columns.keySet()) + ") "
                    + "VALUES (" + String.join(", ", columns.values()) + ")";
            System.out.println(sql);
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
                else {
                    throw new SQLException("Insert failed, no ID obtained.");
                }
            }

        } catch (SQLException | IllegalAccessException error) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, error);
        }
        return 0;
    }

    public void insertWithPK(Object object) {
        try {
            Map<String, String> columns = fieldHandler.getColumns(object);
            String sql = "INSERT INTO " + tableName + " (" + fieldHandler.getPrimaryKeyName() + ", " + String.join(", ", columns.keySet()) + ") "
                    + "VALUES (" + fieldHandler.getPrimaryKeyValue(object) + ", " + String.join(", ", columns.values()) + ")";
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

    public void remove(String id) {
        try {
            String sql = "DELETE FROM " + tableName + " WHERE " + primaryKeyName + "= ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
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

    public List<T> getList(String value, String collumn) {
        ArrayList<T> arrayObj = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + tableName + " WHERE " + collumn + " = '"  + value + "' ORDER BY " + primaryKeyName + " ASC";
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

            String[] arraySetElements = new String[columns.size()];

            int i = 0;
            for (Map.Entry<String, String> entry : columns.entrySet()) {
                arraySetElements[i] = entry.getKey() + " = " + entry.getValue();
                i++;
            }

            String sql = "UPDATE " + tableName + " SET "+ String.join(",", arraySetElements) +" WHERE "
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

            if (rs.next()) {
                for (int i = 1; i <= columnNum; i++) {
                    data.add(rs.getObject(i).toString());
                }
            }

            String args = (String.join(";", data));
            return cls.getDeclaredConstructor(String.class).newInstance(args);

        } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException
                | NoSuchMethodException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public T get(String id) {
        try {
            String sql = "SELECT * FROM " + tableName + " WHERE " + primaryKeyName + " = '" + id + "'";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            ArrayList<String> data = new ArrayList<>();
            int columnNum = rsmd.getColumnCount();

            if (rs.next()) {
                for (int i = 1; i <= columnNum; i++) {
                    data.add(rs.getObject(i).toString());
                }
            }

            String args = (String.join(";", data));
            return cls.getDeclaredConstructor(String.class).newInstance(args);

        } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException
                 | NoSuchMethodException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("bacate");
        }
        return null;
    }

    public boolean contains(String id) {
        try {
            String sql = "SELECT EXISTS(SELECT 1 FROM " + tableName + " WHERE " + primaryKeyName + " = '" + id + "')";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            return rs.getBoolean("exists");
        } catch (SQLException error) {
            logger.fatal(error.getMessage());
        }

        return false;
    }

    public boolean contains(long id) {
        try {
            String sql = "SELECT EXISTS(SELECT 1 FROM " + tableName + " WHERE " + primaryKeyName + " = " + id + ")";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            return rs.getBoolean("exists");
        } catch (SQLException error) {
            logger.fatal(error.getMessage());
        }

        return false;
    }

}