package br.com.lifenance.models;

import br.com.lifenance.dal.GenericDao;

public class ModelFactory {
    public static <T> T getModel(Class<T> cls, String tableName, String id) {
        GenericDao<T> dao = new GenericDao<>(tableName, cls);
        return dao.get(id);
    }

    public static <T> T getModel(Class<T> cls, String tableName, Long id) {
        GenericDao<T> dao = new GenericDao<>(tableName, cls);
        return dao.get(id);
    }
}