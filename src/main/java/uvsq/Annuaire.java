package uvsq;

import java.io.Serializable;
import java.lang.Iterable;
import java.util.Iterator;

public class Annuaire implements Iterable<Equipe>, Serializable {

  private static Annuaire ANNUAIRE; // instance
  private EquipeIterator<Equipe> head; // tête de l'itérateur

  /** Constructeur privé. */
  private Annuaire() {
    head = new EquipeIterator<Equipe>();
  }

  /**
   * Getter du singleton.
   *
   * @return l'annuaire
   */
  public static Annuaire getInstance() {

    if (ANNUAIRE == null) {
      ANNUAIRE = new Annuaire();
    }

    return ANNUAIRE;
  }

  @Override
  public Iterator<Equipe> iterator() {

    return this.head;
  }

  /**
   * Ajout d'une équipe.
   *
   * @param e equipe à ajouter
   */
  public void addEquipe(Equipe e) {

    this.head.add(e);
  }
}
