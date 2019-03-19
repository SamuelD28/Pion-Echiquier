package echec.test;

import echec.classes.Piece;
import echec.classes.Roi;

/**
 * Test de la classe roi
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestRoi extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return Roi.creer(p_couleur);
    }

    /**
     * Test la création et les caractéristiques
     */
    public void testCreer() {
        Piece piece = creerPiece(Piece.Couleur.NOIR);
        assertEquals(0.0, piece.getForce());
        assertEquals('R', piece.getRepresentation());
        assertEquals(Piece.Type.ROI, piece.getType());
    }
}
