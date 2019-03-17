package echec.test;

import echec.classes.Piece;
import echec.classes.Pion;

public class TestPion extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return Pion.creer(p_couleur);
    }
}
