package echec.test;

import echec.classes.Piece;
import echec.classes.Reine;

/**
 * Test de la classe reine
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestReine extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return Reine.creer(p_couleur);
    }

    /**
     * Test la création et les caractéristiques
     */
    public void testCreer() {
        Piece piece = creerPiece(Piece.Couleur.BLANC);
        assertEquals(9.0, piece.getForce());
        assertEquals('d', piece.getRepresentation());
        assertEquals(Piece.Type.REINE, piece.getType());
    }
}
