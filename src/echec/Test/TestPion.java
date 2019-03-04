package echec.Test;

import echec.Class.Pion;
import echec.Class.Position;
import junit.framework.TestCase;

import java.util.ArrayList;

import static echec.Class.Pion.Couleur.BLANC;
import static echec.Class.Pion.Couleur.NOIR;

/**
 * Tests de la classe Pion
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestPion extends TestCase {
    private ArrayList<Pion> m_pieces;

    public void setUp(){
        m_pieces = Pion.obtenirTousLesPions();
    }

    /**
     * Method testant la creation des pieces
     */
    public void testCreer() {
        assertEquals('T', m_pieces.get(0).getRepresentation());
        assertEquals('C', m_pieces.get(2).getRepresentation());
        assertEquals('t', m_pieces.get(16).getRepresentation());
        assertEquals('c', m_pieces.get(18).getRepresentation());

        assertEquals(new Position("a1"),m_pieces.get(0).getPosition());
        assertEquals(new Position("h1"),m_pieces.get(1).getPosition());
        assertEquals(new Position("a2"), m_pieces.get(8).getPosition());
        assertEquals(new Position("h7"), m_pieces.get(31).getPosition());

//        Pion pion1 = new Pion(BLANC);
//        assertEquals(BLANC, pion1.getCouleur());
//        assertEquals('p', pion1.getRepresentation());
//
//        Pion pion2 = new Pion(NOIR);
//        assertEquals(NOIR, pion2.getCouleur());
//        assertEquals('P', pion2.getRepresentation());
//
//        Pion pion3 = new Pion();
//        assertEquals(BLANC, pion3.getCouleur());
//        assertEquals('p', pion3.getRepresentation());
//
//        //On reteste les deux premier pions pour sassurer de ne pas avoir modifier les valeurs
//        assertEquals(BLANC, pion1.getCouleur());
//        assertEquals(NOIR, pion2.getCouleur());
//        assertEquals('p', pion1.getRepresentation());
//        assertEquals('P', pion2.getRepresentation());
    }

    /**
     * Test pour vérifier la couleur d'une piece
     */
    public void testCouleur() {
        assertTrue(m_pieces.get(0).estNoir());
        assertTrue(m_pieces.get(16).estBlanc());
    }
}

