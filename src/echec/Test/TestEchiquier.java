package echec.Test;

import echec.Class.Echiquier;
import echec.Class.Pion;
import junit.framework.TestCase;

import static echec.Class.Pion.Couleur.BLANC;
import static echec.Class.Pion.Couleur.NOIR;

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
        assertTrue(m_echiquier.ajouterPion(pion, "a1"));
        assertEquals(1, m_echiquier.getNombrePions());
        assertEquals(pion, m_echiquier.getPion("a1"));
        assertEquals(BLANC, m_echiquier.getPion("a1").getCouleur());

        Pion pion2 = new Pion(NOIR);
        m_echiquier.ajouterPion(pion2, "b6");
        assertEquals(2, m_echiquier.getNombrePions());
        assertEquals(pion2, m_echiquier.getPion("b6"));
        assertEquals(NOIR, m_echiquier.getPion("b6").getCouleur());

        assertEquals(pion, m_echiquier.getPion("a1"));

        assertFalse(m_echiquier.ajouterPion(pion2, "zz"));
        assertEquals(2, m_echiquier.getNombrePions());
    }

    /**
     * Methode testant l'initialisation d'un echiquier. Vérifie
     * que les pièces sont bel et bien au bon endroit et que le
     * nombre de pièces correspond également.
     */
    public void testInitialiser() {

        //On initialise l'echiquier avec des X
        m_echiquier.initialiser();
        //On seed l'echiquier avec des pions tests
        m_echiquier.seedPions(BLANC, 6);
        m_echiquier.seedPions(NOIR, 1);

        String representationEhciquier =    "XXXXXXXX\n" +
                                            "PPPPPPPP\n" +
                                            "XXXXXXXX\n" +
                                            "XXXXXXXX\n" +
                                            "XXXXXXXX\n" +
                                            "XXXXXXXX\n" +
                                            "pppppppp\n" +
                                            "XXXXXXXX\n";
        System.out.println(m_echiquier.toString());

        //On teste le nombres de pions present sur l'echiquier
        assertEquals(16, m_echiquier.getNombrePions());
        //On teste la representation graphique de l'echiquier
        assertEquals(representationEhciquier, m_echiquier.toString());
    }
}
