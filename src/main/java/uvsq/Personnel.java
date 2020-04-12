package uvsq;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public final class Personnel extends Equipe implements Serializable {

  private final String nom;
  private final String prenom;
  private final String fonction;
  private final List<String> telephone;
  private final java.time.LocalDate dateNaissance;

  public static class Builder {

    private final String nom;
    private final String prenom;
    private final String fonction;
    private List<String> telephone = null;
    private java.time.LocalDate dateNaissance = java.time.LocalDate.now();

    /**
     * Builder pour suivre le pattern Builder.
     *
     * @param nom Le nom du personnel
     * @param prenom Le prenom du personnel
     * @param fonction Chaine désignant la fonction du personnel
     */
    public Builder(String nom, String prenom, String fonction) {

      this.nom = nom;
      this.prenom = prenom;
      this.fonction = fonction;
    }

    /**
     * Permet d'ajouter les numéros de téléphone lors de la création avec le builder.
     *
     * @param phone Liste des numéros de téléphone à ajouter
     * @return le builder
     */
    public Builder updatePhoneList(List<String> phone) {

      this.telephone = phone;

      return this;
    }

    /**
     * Permet de modifier la date de naissance lors de la création avec le builder.
     *
     * @param t Date
     * @return le builder
     */
    public Builder updateDateNaissance(java.time.LocalDate t) {

      this.dateNaissance = t;

      return this;
    }

    public Personnel build() {

      return new Personnel(this);
    }
  }

  private Personnel(Builder build) {

    this.nom = build.nom;
    this.prenom = build.prenom;
    this.fonction = build.fonction;
    this.telephone = build.telephone;
    this.dateNaissance = build.dateNaissance;
  }

  public String getNom() {
    return this.nom;
  }

  public List<String> getTel() {

    return Collections.unmodifiableList(this.telephone);
  }

  public java.time.LocalDate getLocalDate() {

    return this.dateNaissance;
  }

  public void printNom() {
    System.out.println(this.nom);
  }
}
