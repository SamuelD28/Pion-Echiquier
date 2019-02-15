package echec.Class;

import echec.Test.Echiquier;
import echec.Test.Pion;
import junit.framework.TestCase;

import static echec.Test.Pion.Couleur.BLANC;
import static echec.Test.Pion.Couleur.NOIR;

/**
 * Tests de la classe Echiquier
 *
 * @author Samuel Dubé
 * @author Samuel Colassin
 */
public class TestEchiquier extends TestCase {
    private Echiquier m_echiquier;

    /**
     * Réinitialise l'échiquier à chaque exécution des tests
     */
    public void setUp() {
        m_echiquier = new Echiquier();
    }

    /**
     * Test la création d'un échiquier
     */
    public void testCreer() {
        assertEquals(0, m_echiquier.getNombrePions());
    }

    /**
     * Test l'ajout d'un pion dans un échiquier
     */
    public void testAjouterPion() {
        Pion pion = new Pion();
        m_echiquier.ajouterPion(pion, "a1");
        assertEquals(1, m_echiquier.getNombrePions());
        assertEquals(pion, m_echiquier.getPion("a1"));
        assertEquals(BLANC, m_echiquier.getPion("a1").getCouleur());

        Pion pion2 = new Pion(NOIR);
        m_echiquier.ajouterPion(pion2, "b6");
        assertEquals(2, m_echiquier.getNombrePions());
        assertEquals(pion2, m_echiquier.getPion("b6"));
        assertEquals(NOIR, m_echiquier.getPion("b6").getCouleur());

        assertEquals(pion, m_echiquier.getPion("a1"));
    }

    public void testInitialiser() {

        m_echiquier.initialiser();

        String representationEhciquier =    "XXXXXXXX\n" +
                                            "PPPPPPPP\n" +
                                            "XXXXXXXX\n" +
                                            "XXXXXXXX\n" +
                                            "XXXXXXXX\n" +
                                            "XXXXXXXX\n" +
                                            "pppppppp\n" +
                                            "XXXXXXXX\n";

        System.out.println(m_echiquier.toString());
        m_echiquier.toString();
        assertEquals(representationEhciquier, m_echiquier.toString());
    }
}
