package echec;

import junit.framework.TestCase;

/**
 * Tests de la classe Pion
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestPion extends TestCase {
    /** Test la création d'un pion */
    public void testCreer() {
        String couleurPion = "vert";
        String positionPion = "a1";
        Pion pion = new Pion(couleurPion, positionPion);
        assertEquals(couleurPion, pion.getCouleur());
        assertEquals(positionPion, pion.getPosition());

        String couleurPion2 = "vert";
        String positionPion2 = "b2";
        Pion pion2 = new Pion(couleurPion2, positionPion2);
        assertEquals(couleurPion2, pion2.getCouleur());
        assertEquals(positionPion2, pion2.getPosition());

        assertEquals(couleurPion, pion.getCouleur());
        assertEquals(positionPion, pion.getPosition());
    }
}
