package echec;

import junit.framework.TestCase;

/**
 * Tests de la classe Pion
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestPion extends TestCase {

    public static final String BLANC = "blanc";
    public static final String VERT = "vert";
    public static final String NOIR = "noir";

    /** Test la création d'un pion */
    public void testCreer() {
        Pion pion1 = new Pion(VERT);
        assertEquals(VERT, pion1.getCouleur());

        Pion pion2 = new Pion(NOIR);
        assertEquals(NOIR, pion2.getCouleur());

        Pion pion3 = new Pion();
        assertEquals(BLANC, pion3.getCouleur());

        assertEquals(VERT, pion1.getCouleur());
        assertEquals(NOIR, pion2.getCouleur());
        assertEquals(BLANC, pion3.getCouleur());
    }
}

