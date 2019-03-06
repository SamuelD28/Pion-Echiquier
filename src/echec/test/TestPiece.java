package echec.Test;

import echec.classes.IPiece;
import echec.classes.Piece;
import junit.framework.TestCase;

import static echec.classes.IPiece.Couleur.*;
import static echec.classes.IPiece.Type.*;

/**
 * Tests de la classe Pion
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestPiece extends TestCase {
    private Piece m_piece;

    public void setUp() {
        m_piece = new Piece(NOIR, ROI);
    }

    /**
     * Method testant la creation des pieces
     */
    public void testCreer() {
        assertEquals(ROI, m_piece.getType());
        assertEquals("R", m_piece.getRepresentation() + "");
    }

    /**
     * Test permettant de vérifier si on indique la
     * bonne force d'une pièce
     */
    public void testGetForce() {
        assertEquals(0.0, m_piece.getForce());
        Piece piece = new Piece(BLANC, FOU);
        assertEquals(3.0, piece.getForce());
    }

    /**
     * Test poru verifier que les bonne valeurs ont
     * etes associe au type de piece.
     */
    public void testType()
    {
        IPiece pion = new Piece(BLANC, PION);
        IPiece cavalier = new Piece(BLANC, CAVALIER);
        IPiece roi = new Piece(BLANC, ROI);
        IPiece reine = new Piece(BLANC, REINE);
        IPiece fou = new Piece(BLANC, FOU);
        IPiece tour = new Piece(BLANC, TOUR);

        assertEquals(1.0, pion.getForce());
        assertEquals(2.5, cavalier.getForce());
        assertEquals(3.0, fou.getForce());
        assertEquals(5.0, tour.getForce());
        assertEquals(9.0, reine.getForce());
        assertEquals(0.0, roi.getForce());

        assertEquals('p', pion.getRepresentation());
        assertEquals('c', cavalier.getRepresentation());
        assertEquals('f', fou.getRepresentation());
        assertEquals('t', tour.getRepresentation());
        assertEquals('d', reine.getRepresentation());
        assertEquals('r', roi.getRepresentation());
    }

    /**
     * Test pour vérifier la couleur d'une piece
     */
    public void testCouleur() {
        assertEquals(NOIR, m_piece.getCouleur());
        Piece piece = new Piece(BLANC, REINE);
        assertEquals(BLANC, piece.getCouleur());
        assertTrue(m_piece.estNoir());
        assertFalse(piece.estNoir());
        assertFalse(m_piece.estBlanc());
    }
}

