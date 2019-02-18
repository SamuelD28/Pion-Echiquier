package echec.Test;

import echec.Class.Position;
import echec.Class.Position.PositionInvalideException;
import junit.framework.TestCase;

import static echec.Class.Position.PositionInvalideException.ERR_POSITION_INVALIDE;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Classe de test pour verifier les comportements
 * de la classe Position
 *
 * @author Samuel Dube
 * @author Samuel Colassin
 */
public class TestPosition extends TestCase {

    /**
     * Methode qui teste la creation de nouvelle
     * position.
     */
    public void testCreer() {

        Position position1 = new Position("A1");
        Position position2 = new Position(7, 3);

        assertEquals(0, position1.getX());
        assertEquals(0, position1.getY());

        assertEquals(7, position2.getX());
        assertEquals(3, position2.getY());

        //On verifie que la creation d'une position erronnee lance belle et bien une exception de type position invalide
        try {
            new Position("AAAAA");
            new Position(19, 22);
            fail();
        } catch (PositionInvalideException e) {
            assertEquals(ERR_POSITION_INVALIDE, e.getMessage());
        }
    }

    /**
     * Methode qui teste l'assignation d'une position existante
     * a une nouvelle position
     */
    public void testAssignation() {

        Position position1 = new Position("A1");

        //Devrait change la position a 1,1
        position1.Assigner("B2");

        assertEquals(1, position1.getX());
        assertEquals(1, position1.getY());

        //Ne devrait pas modifier la position
        assertFalse(position1.Assigner("ZZZZ"));
        assertFalse(position1.Assigner(20, 20));

        //la position devrait toujours etre 1,1
        assertEquals(1, position1.getX());
        assertEquals(1, position1.getY());

        //Devrait modifier la position a 3,3
        assertTrue(position1.Assigner("C3"));
        assertTrue(position1.Assigner(3, 3));

        //La position devrait maintenant etre 3,3
        assertEquals(3, position1.getX());
        assertEquals(3, position1.getY());
    }

    /**
     * Methode qui teste qu'une position x,y est bel
     * et bien equivalente a une la meme position x,y
     */
    public void testComparaison() {

        Position position1 = new Position("A1");  //x,y = 0,0
        Position position2 = new Position(0, 0);     //x,y = 0,0
        Position position3 = new Position("C4"); //x,y = 2,3

        assertEquals(position1, position2);
        assertNotEquals(position3, position2);

        position1.Assigner("C4");

        assertEquals(position1, position3);
        assertNotEquals(position1, position2);
    }
}
