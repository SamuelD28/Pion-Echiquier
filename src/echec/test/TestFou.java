package echec.test;

import echec.classes.Fou;
import echec.classes.Piece;

public class TestFou extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return Fou.creer(p_couleur);
    }
}
