package echec.test;

import echec.classes.Piece;
import echec.classes.Tour;

/**
 * Test de la classe tour
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestTour extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return new Tour(p_couleur);
    }

    @Override
    public void testMouvement() {} //A implementer plus tard

    /**
     * Test la création et les caractéristiques
     */
    public void testCreer() {
        Piece piece = creerPiece(Piece.Couleur.BLANC);
        assertEquals(5.0, piece.getForce());
        assertEquals('t', piece.getRepresentation());
        assertEquals(Piece.Type.TOUR, piece.getType());
    }
}
