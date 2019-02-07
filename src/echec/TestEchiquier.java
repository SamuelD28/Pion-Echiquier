package echec;

import junit.framework.TestCase;

public class TestEchiquier extends TestCase {

    private Echiquier m_echiquier;

    public void setUp() {
        m_echiquier = new Echiquier();
    }

    public void testCreer() {
        assertEquals(0, m_echiquier.getNombrePions());
    }

    public void testAjouterPion() {

        Pion pion = new Pion();
        m_echiquier.ajouterPion(pion, "a1");
        assertEquals(1 , m_echiquier.getNombrePions());
        assertEquals(pion, m_echiquier.getPion("a1"));

        Pion pion2 = new Pion("noir");
        m_echiquier.ajouterPion(pion2, "b6");
        assertEquals(2 , m_echiquier.getNombrePions());
        assertEquals(pion2, m_echiquier.getPion("b6"));
    }
}
