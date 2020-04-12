package uvsq;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GroupeDao implements Dao<Groupe> {

  @Override
  public Groupe create(Groupe obj) {
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("groupe")))) {
      out.writeObject(obj);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    return obj;
  }

  @Override
  public Groupe find(String id) {
    Groupe g = new Groupe("Vide");
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(id)))) {
      g = (Groupe) in.readObject();

    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }

    return g;
  }

  @Override
  public void delete(String file) {

    try {
      File f = new File(file);

      if (f.delete()) {
        System.out.println("Deletion complete");
      } else {
        System.out.println("Failure");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
