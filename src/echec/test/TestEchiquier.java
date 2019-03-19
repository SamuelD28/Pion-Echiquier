package echec.test;

import echec.classes.*;
import junit.framework.TestCase;

import static echec.classes.Piece.Couleur.*;
import static echec.classes.Piece.Type.*;

/**
 * Tests de la classe Echiquier
 *
 * @author Samuel Dubé
 * @author Samuel Colassin
 */
public class TestEchiquier extends TestCase {
    private final static String REPRESENTATION_DEPART =
            "TCFDRFCT\n" +
                    "PPPPPPPP\n" +
                    "XXXXXXXX\n" +
                    "XXXXXXXX\n" +
                    "XXXXXXXX\n" +
                    "XXXXXXXX\n" +
                    "pppppppp\n" +
                    "tcfdrfct";
    private Echiquier m_echiquier;

    /**
     * Réinitialise l'échiquier à chaque exécution des tests
     */
    public void setUp() {
        m_echiquier = new Echiquier();
    }

    /**
     * Methode testant l'initialisation d'un echiquier. Vérifie
     * que les pièces sont bel et bien au bon endroit et que le
     * nombre de pièces correspond également.
     */
    public void testCreer() {
        System.out.println(m_echiquier.toString());

        assertEquals(REPRESENTATION_DEPART, m_echiquier.toString());
        assertEquals(32, m_echiquier.getNombrePieces());

        m_echiquier = new Echiquier();
        assertEquals(32, m_echiquier.getNombrePieces());
    }

    /**
     * Permet de tester si l'échiquier retourne le bon nombre de pièce désiré
     * sur l'échiquier selon la couleur et le type de la pièce.
     */
    public void testGetNombrePieces() {
        assertEquals(2, m_echiquier.getNombrePieces(BLANC, CAVALIER));
        assertEquals(1, m_echiquier.getNombrePieces(NOIR, REINE));
        assertEquals(8, m_echiquier.getNombrePieces(NOIR, PION));
    }

    /**
     * Permet de tester si l'échiquier retourne la bonne pièce selon une position
     * dans l'échiquier.
     */
    public void testGetPiece() {
        Piece pionNoir = Pion.creer(NOIR);
        Piece roiNoir = Roi.creer(NOIR);

        assertEquals(pionNoir, m_echiquier.getPiece(new Position("d2")));
        assertEquals(roiNoir, m_echiquier.getPiece(new Position("e1")));

        Piece piece1 = m_echiquier.getPiece(new Position("b8"));
        Piece piece2 = m_echiquier.getPiece(new Position("h1"));

        assertNotNull(piece1);
        assertNotNull(piece2);

        assertEquals('c', piece1.getRepresentation());
        assertEquals('T', piece2.getRepresentation());

        Piece piece3 = m_echiquier.getPiece(new Position(4, 5));
        Piece piece4 = m_echiquier.getPiece(new Position(7, 4));

        assertNull(piece3);
        assertNull(piece4);
    }

    /**
     * Permet de tester la force d'une couleur sur l'échiquier selon
     * le nombre de pièce restante.
     */
    public void testForceEchiquier() {
        assertEquals(38.0, m_echiquier.getForceEchiquier(BLANC));
        assertEquals(38.0, m_echiquier.getForceEchiquier(NOIR));
    }

    /**
     * Permet de tester si l'emplacement d'une pièce est bonne après
     * l'avoir mis à une place désirée.
     */
    public void testPlacerPiece() {
        Piece cavalierNoir = Cavalier.creer(NOIR);

        assertTrue(m_echiquier.placerPiece(cavalierNoir, new Position("c5")));
        String echiquierAjout = "TXFDRFCT\n" +
                "PPPPPPPP\n" +
                "XXXXXXXX\n" +
                "XXXXXXXX\n" +
                "XXCXXXXX\n" +
                "XXXXXXXX\n" +
                "pppppppp\n" +
                "tcfdrfct";

        System.out.println();
        System.out.println(m_echiquier.toString());

        assertEquals(echiquierAjout, m_echiquier.toString());
        assertFalse(m_echiquier.placerPiece(cavalierNoir, new Position(0, 0)));
        assertTrue(m_echiquier.placerPiece(cavalierNoir, new Position("d5")));
        echiquierAjout = "TXFDRFXT\n" +
                "PPPPPPPP\n" +
                "XXXXXXXX\n" +
                "XXXXXXXX\n" +
                "XXCCXXXX\n" +
                "XXXXXXXX\n" +
                "pppppppp\n" +
                "tcfdrfct";
        System.out.println();
        System.out.println(m_echiquier.toString());
        assertEquals(echiquierAjout, m_echiquier.toString());

        m_echiquier = new Echiquier();
        assertEquals(REPRESENTATION_DEPART, m_echiquier.toString());
    }

    public void testBougerPiece()
    {
        Piece piece = m_echiquier.getPiece(new Position(0,0));

        Position deplacement1 = new Position(0,3);

        m_echiquier.placerPiece(piece, deplacement1);
    }
}
