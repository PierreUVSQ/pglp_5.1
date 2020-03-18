package uvsq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    /**
     * On crée un annuaire complet et on l'enregistre. On le recharge et compare les noms des différents parcours
     *
     */
    @Test
    public void testAnnuaireComplet() {

        Annuaire a = Annuaire.getInstance();
        String tel = new String("00000000");
        Groupe gg = new Groupe("PDG");
        Groupe g2 = new Groupe("VICE_PRESIDENT");
        List<String> tmp = new ArrayList<>();
        tmp.add(tel);
        tmp.add("12345678");
        Personnel p1 = new Personnel.Builder("Smith", "John", "ComputerScienist").updatePhoneList(tmp).build();
        Personnel p2 = new Personnel.Builder("pg", "lp", "class").updatePhoneList(tmp).build();

        gg.ajoutMembre(p1);
        gg.ajoutMembre(p2);
        g2.ajoutMembre(p1);
        a.addEquipe(p1);
        a.addEquipe(new Groupe("Groupe1"));
        a.addEquipe(new Groupe("Groupe2"));
        a.addEquipe(gg);
        a.addEquipe(new Groupe("Groupe3"));
        a.addEquipe(new Groupe("Groupe4"));
        a.addEquipe(g2);

        System.out.println("Created");
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("/home/piere/Bureau/data")))) {
            out.writeObject(Annuaire.getInstance());
        }
        catch(IOException ioe){

        }
        System.out.println("registered");

        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("/home/piere/Bureau/data")))) {
            Annuaire  test = (Annuaire) in.readObject();
            for(Equipe e : test) {

                e.printNom();
            }
          

        }
        catch(ClassNotFoundException | IOException e){

        }

        System.out.println("Start");



    }




}
