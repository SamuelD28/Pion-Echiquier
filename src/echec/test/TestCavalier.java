package echec.test;

import echec.classes.Cavalier;
import echec.classes.Piece;

/**
 * Test de la classe cavalier
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestCavalier extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return Cavalier.creer(p_couleur);
    }

    /**
     * Test la création et les caractéristiques
     */
    public void testCreer() {
        Piece piece = creerPiece(Piece.Couleur.BLANC);
        assertEquals(2.5, piece.getForce());
        assertEquals('c', piece.getRepresentation());
        assertEquals(Piece.Type.CAVALIER, piece.getType());
    }
}
