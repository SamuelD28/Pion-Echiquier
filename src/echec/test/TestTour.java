package echec.test;

import echec.classes.Piece;
import echec.classes.Tour;

public class TestTour extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return Tour.creer(p_couleur);
    }
}
