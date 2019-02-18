package echec.Test;

import echec.Class.Pion;
import junit.framework.TestCase;

import static echec.Class.Pion.Couleur.BLANC;
import static echec.Class.Pion.Couleur.NOIR;

/**
 * Tests de la classe Pion
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestPion extends TestCase {
    /**
     * Method testant la creatino d'un pion
     */
    public void testCreer() {

        Pion pion1 = new Pion(BLANC);
        assertEquals(BLANC, pion1.getCouleur());
        assertEquals('p', pion1.getRepresentation());

        Pion pion2 = new Pion(NOIR);
        assertEquals(NOIR, pion2.getCouleur());
        assertEquals('P', pion2.getRepresentation());

        Pion pion3 = new Pion();
        assertEquals(BLANC, pion3.getCouleur());
        assertEquals('p', pion3.getRepresentation());

        //On reteste les deux premier pions pour sassurer de ne pas avoir modifier les valeurs
        assertEquals(BLANC, pion1.getCouleur());
        assertEquals(NOIR, pion2.getCouleur());
        assertEquals('p', pion1.getRepresentation());
        assertEquals('P', pion2.getRepresentation());
    }
}

