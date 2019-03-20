package echec.test;

import echec.classes.Piece;
import echec.classes.Pion;

/**
 * Test de la classe pion
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestPion extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return new Pion(p_couleur);
    }

    /**
     * Test la création et les caractéristiques
     */
    public void testCreer() {
        Piece piece = creerPiece(Piece.Couleur.BLANC);
        assertEquals(1.0, piece.getForce());
        assertEquals('p', piece.getRepresentation());
        assertEquals(Piece.Type.PION, piece.getType());
    }
}
