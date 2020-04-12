package uvsq;

public interface Dao<T> {

  T create(T obj);

  T find(String id);

  void delete(String file);
}
