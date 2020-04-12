package uvsq;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonnelDao implements Dao<Personnel> {

  @Override
  public Personnel create(Personnel obj) {
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("personnel")))) {
      out.writeObject(obj);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    return obj;
  }

  @Override
  public Personnel find(String id) {
    Personnel p = null;
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(id)))) {
      p = (Personnel) in.readObject();

    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }

    return p;
  }

  @Override
  public void delete(String file) {
    try {
      File f = new File(file);

      if (!f.delete()) {
        System.out.println("Failure");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
