package echec.test;

import echec.classes.Fou;
import echec.classes.Piece;

/**
 * Test de la classe fou
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestFou extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return Fou.creer(p_couleur);
    }

    @Override
    public void testMouvement() {} //A implementer plus tard

    /**
     * Test la création et les caractéristiques
     */
    public void testCreer() {
        Piece piece = creerPiece(Piece.Couleur.BLANC);
        assertEquals(3.0, piece.getForce());
        assertEquals('f', piece.getRepresentation());
        assertEquals(Piece.Type.FOU, piece.getType());
    }
}
