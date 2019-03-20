package echec.test;

import echec.classes.*;
import echec.classes.Piece.Couleur;
import junit.framework.TestCase;

import static echec.classes.Piece.Couleur.*;

/**
 * Tests de la classe Pion
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public abstract class TestPiece extends TestCase {
    /**
     * Permet de creer la pièce du bon type selon
     * le test qui l'appel.
     *
     * @param p_couleur couleur de la piece
     * @return Une Piece du type appelé
     */
    abstract protected Piece creerPiece(Couleur p_couleur);

    /**
     * Test la couleur d'une pièce
     */
    public void testCouleur() {
        Piece piece = creerPiece(BLANC);
        assertEquals(BLANC, piece.getCouleur());
        assertFalse(piece.estNoir());
        assertTrue(piece.estBlanc());
    }
}

