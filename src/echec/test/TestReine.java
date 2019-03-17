package echec.test;

import echec.classes.Piece;
import echec.classes.Reine;

public class TestReine extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return Reine.creer(p_couleur);
    }
}
