package uvsq;

import java.io.Serializable;
import java.util.Iterator;

public class EquipeIterator<Equipe> implements Iterator<Equipe>, Serializable {

  private int index;
  private Node<Equipe> elem;

  @Override
  public boolean hasNext() {
    if (elem != null) {
      return true;
    }
    return false;
  }

  @Override
  public Equipe next() {
    Equipe tmp = elem.getElement();
    elem = elem.getNext();
    index++;
    return tmp;
  }

  /**
   * Ajout de l'élément suivant dans l'itérateur.
   * @param n equipe suivante
   */
  public void add(Equipe n) {

    if (elem == null) {
      this.elem = new Node<Equipe>(n);
    } else {

      this.elem.addElement(n);
    }
  }
}
