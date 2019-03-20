package echec.test;

import echec.classes.Mouvement;
import echec.classes.Position;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;

import static echec.classes.Mouvement.TypeMouvement.*;

public class TestMouvement extends TestCase {
    /**
     * Test permettant de verifier que la creation
     * dun mouvement est correcte
     */
    public void testCreer() {
        Mouvement mouvement = new Mouvement(8, new ArrayList<>(Arrays.asList(DIAGONALE)));

        assertTrue(mouvement.getTypesMouvement().contains(DIAGONALE));
        assertEquals(8, mouvement.getPasMaximum());
        assertEquals(1, mouvement.getPasMinimum());

        mouvement = new Mouvement(4, new ArrayList<>(Arrays.asList(LATERAL, DIAGONALE)));

        assertTrue(mouvement.getTypesMouvement().contains(DIAGONALE));
        assertTrue(mouvement.getTypesMouvement().contains(LATERAL));
        assertEquals(4, mouvement.getPasMaximum());
        assertEquals(1, mouvement.getPasMinimum());
    }

    /**
     * Test permettant de tester la methode de verification
     * de la classe mouvement pour determiner si un deplacement
     * est conforme a la configuration du mouvement
     */
    public void testEstValide()
    {
        Mouvement mouvement = new Mouvement(8, new ArrayList<>(Arrays.asList(DIAGONALE)));

        Mouvement deplacementValide = Mouvement.calculer(new Position(0,0), new Position(5,5));
        Mouvement deplacementInvalide = Mouvement.calculer(new Position(0,0), new Position(5,4));

        assertTrue(mouvement.estValide(deplacementValide));
        assertFalse(mouvement.estValide(deplacementInvalide));

        Mouvement mouvement1 = new Mouvement(8, new ArrayList<>(Arrays.asList(LATERAL)));
        Mouvement deplacementValide1 = Mouvement.calculer(new Position(0,0), new Position(0,5));
        Mouvement deplacementInvalide1 = Mouvement.calculer(new Position(0,0), new Position(1,5));

        assertTrue(mouvement1.estValide(deplacementValide1));
        assertFalse(mouvement.estValide(deplacementInvalide1));
    }

    /**
     * Test permettant de verifier que la methode permettant
     * de calculer le mouvement avec deux position.
     */
    public void testCalculer()
    {
        Mouvement mouvement = Mouvement.calculer(new Position(0,0), new Position(0,5));

        assertEquals(5, mouvement.getPasMaximum());
        assertEquals(1, mouvement.getPasMinimum());
        assertTrue(mouvement.getTypesMouvement().contains(LATERAL));
        assertFalse(mouvement.getTypesMouvement().contains(EN_L));

        mouvement = Mouvement.calculer(new Position(1,1), new Position(5,5));
        assertEquals(4, mouvement.getPasMaximum());
        assertEquals(1, mouvement.getPasMinimum());
        assertTrue(mouvement.getTypesMouvement().contains(DIAGONALE));
        assertFalse(mouvement.getTypesMouvement().contains(LATERAL));

        mouvement = Mouvement.calculer(new Position(0,0), new Position(3,7));
        assertTrue(mouvement.getTypesMouvement().contains(NON_VALIDE));
    }
}

