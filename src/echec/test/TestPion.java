package echec.Test;

import echec.classes.Piece;
import echec.classes.Pion;

public class TestPion extends TestPiece {

    @Override
    protected Piece testCreerPiece(Piece.Couleur p_couleur) {
        return Pion.creer(p_couleur);
    }
}
