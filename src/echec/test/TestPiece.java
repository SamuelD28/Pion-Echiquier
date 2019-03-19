package echec.Test;

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

    private Piece m_piece;

    public void setUp() {
        m_piece = Roi.creer(NOIR);
    }

    /**
     * Method testant la creation des pieces
     */
    abstract protected Piece creerPiece(Couleur p_couleur);

    /**
     * Test permettant de vérifier si on indique la
     * bonne force d'une pièce
     */
    public void testGetForce() {
        assertEquals(0.0, m_piece.getForce());
        Piece piece = Reine.creer(BLANC);
        assertEquals(9.0, piece.getForce());
    }

    /**
     * Test poru verifier que les bonne valeurs ont
     * etes associe au type de piece.
     */
    public void testType()
    {
        Piece pion = Pion.creer(BLANC);
        Piece cavalier = Cavalier.creer(BLANC);
        Piece roi = Roi.creer(NOIR);
        Piece reine = Reine.creer(BLANC);
        Piece fou = Fou.creer(BLANC);
        Piece tour = Tour.creer(BLANC);

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
        assertEquals('R', roi.getRepresentation());
    }

    protected void testCouleur(Piece piece, Couleur couleurAttendu)
    {
        assertEquals(couleurAttendu, piece.getCouleur());
        piece = Reine.creer(BLANC);
        assertEquals(BLANC, piece.getCouleur());
        assertFalse(piece.estNoir());
        assertTrue(piece.estBlanc());
    }
}

