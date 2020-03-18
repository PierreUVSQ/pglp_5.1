package uvsq;

public class DAOFactory {

    public static DAO<Annuaire> getAnnuaireDAO(){

        return new AnnuaireDAO();
    }


}
