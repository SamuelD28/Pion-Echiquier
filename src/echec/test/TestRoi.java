package echec.test;

import echec.classes.Piece;
import echec.classes.Roi;

public class TestRoi extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return Roi.creer(p_couleur);
    }
}
