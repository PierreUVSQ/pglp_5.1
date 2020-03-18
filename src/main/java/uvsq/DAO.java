package uvsq;

import java.sql.Connection;

public interface DAO<T> {


    Connection connect = null;

    public T create(T obj);
    public T find(String id);
    public T update(T obj);
    public void delete(T obj);



}
