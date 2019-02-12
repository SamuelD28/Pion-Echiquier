package echec;

import junit.framework.TestCase;

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
        assertEquals(1 , m_echiquier.getNombrePions());
        assertEquals(pion, m_echiquier.getPion("a1"));
        assertEquals(TestPion.BLANC, m_echiquier.getPion("a1").getCouleur());

        Pion pion2 = new Pion(TestPion.NOIR);
        m_echiquier.ajouterPion(pion2, "b6");
        assertEquals(2 , m_echiquier.getNombrePions());
        assertEquals(pion2, m_echiquier.getPion("b6"));
        assertEquals(TestPion.NOIR, m_echiquier.getPion("b6").getCouleur());

        assertEquals(pion, m_echiquier.getPion("a1"));
    }
}
