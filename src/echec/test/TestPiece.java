package echec.Test;

import echec.classes.IPiece;
import echec.classes.Piece;
import junit.framework.TestCase;

/**
 * Tests de la classe Pion
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestPiece extends TestCase {
    private Piece m_piece;

    public void setUp() {
        m_piece = new Piece(IPiece.Couleur.NOIR, IPiece.Type.ROI);
    }

    /**
     * Method testant la creation des pieces
     */
    public void testCreer() {
        //TODO Peut-être pas la meilleur facon de tester la création
        assertEquals(IPiece.Type.ROI, m_piece.getType());
        assertEquals("R", m_piece.getRepresentation() + "");
    }

    /**
     * Test permettant de vérifier si on indique la
     * bonne force d'une pièce
     */
    public void testGetForce() {
        assertEquals(0.0, m_piece.getForce());
        Piece piece = new Piece(IPiece.Couleur.BLANC, IPiece.Type.FOU);
        assertEquals(3.0, piece.getForce());
    }

    /**
     * Test pour vérifier la couleur d'une piece
     */
    public void testCouleur() {
        assertEquals(IPiece.Couleur.NOIR, m_piece.getCouleur());
        Piece piece = new Piece(IPiece.Couleur.BLANC, IPiece.Type.REINE);
        assertEquals(IPiece.Couleur.BLANC, piece.getCouleur());
        assertTrue(m_piece.estNoir());
        assertFalse(piece.estNoir());
        assertFalse(m_piece.estBlanc());
    }
}

