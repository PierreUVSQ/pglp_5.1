package uvsq;

public class DAOFactory {

    public static DAO<Annuaire> getAnnuaireDAO(){

        return new AnnuaireDAO();
    }

    public static DAO<Groupe> getGroupeDAO(){

        return new GroupeDAO();
    }

    public static DAO<Personnel> getPersonnelDAO(){

        return new PersonnelDAO();
    }
}
