package echec.test;

import echec.classes.*;

import static echec.classes.Piece.Couleur.NOIR;

/**
 * Test de la classe reine
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class TestReine extends TestPiece {
    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return Reine.creer(p_couleur);
    }

    /**
     * Test la création et les caractéristiques
     */
    public void testCreer() {
        Piece piece = creerPiece(Piece.Couleur.BLANC);
        assertEquals(9.0, piece.getForce());
        assertEquals('d', piece.getRepresentation());
        assertEquals(Piece.Type.REINE, piece.getType());
    }

    @Override
    public void testMouvement()
    {
        Piece reine = Reine.creer(NOIR);

        Mouvement deplacement = Mouvement.calculer(new Position(0,0), new Position(3,3));
        assertTrue(reine.getMouvement().estValide(deplacement));

        Mouvement deplacement2 = Mouvement.calculer(new Position(3, 5), new Position(7,5));
        assertTrue(reine.getMouvement().estValide(deplacement2));

        Mouvement deplacement3 = Mouvement.calculer(new Position(1,1), new Position(2,3));
        assertFalse(reine.getMouvement().estValide(deplacement3));

        Mouvement deplacement4 = Mouvement.calculer(new Position(2,2), new Position(5,7));
        assertFalse(reine.getMouvement().estValide(deplacement4));
    }
}
