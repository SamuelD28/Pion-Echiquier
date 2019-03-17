package echec.test;

import echec.classes.Cavalier;
import echec.classes.Piece;

public class TestCavalier extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return Cavalier.creer(p_couleur);
    }
}
