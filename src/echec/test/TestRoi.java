package echec.test;

import echec.classes.*;

import static echec.classes.Piece.Couleur.NOIR;

/**
 * Test de la classe roi
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestRoi extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return new Roi(p_couleur);
    }

    /**
     * Test la création et les caractéristiques
     */
    public void testCreer() {
        Piece piece = creerPiece(Piece.Couleur.NOIR);
        assertEquals(0.0, piece.getForce());
        assertEquals('R', piece.getRepresentation());
        assertEquals(Piece.Type.ROI, piece.getType());
    }

    @Override
    public void testMouvement() {
        Piece roi = new Roi(NOIR);

        Mouvement deplacement = Mouvement.calculer(new Position(0, 0), new Position(0, 1));
        assertTrue(roi.getMouvement().estValide(deplacement));

        Mouvement deplacement2 = Mouvement.calculer(new Position(3, 5), new Position(4, 5));
        assertTrue(roi.getMouvement().estValide(deplacement2));

        Mouvement deplacement3 = Mouvement.calculer(new Position(1, 1), new Position(3, 3));
        assertFalse(roi.getMouvement().estValide(deplacement3));

        Mouvement deplacement4 = Mouvement.calculer(new Position(2, 2), new Position(5, 7));
        assertFalse(roi.getMouvement().estValide(deplacement4));
    }
}
