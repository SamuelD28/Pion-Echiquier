package echec.test;

import echec.classes.Echiquier;
import echec.classes.IPiece;
import echec.classes.Position;
import junit.framework.TestCase;

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
    }

    /**
     * Permet de tester si l'échiquier retourne le bon nombre de pièce désiré
     * sur l'échiquier selon la couleur et le type de la pièce.
     */
    public void testGetNombrePieces() {
        assertEquals(2, m_echiquier.getNombrePieces(IPiece.Couleur.BLANC, IPiece.Type.CAVALIER));
        assertEquals(1, m_echiquier.getNombrePieces(IPiece.Couleur.NOIR, IPiece.Type.REINE));
        assertEquals(8, m_echiquier.getNombrePieces(IPiece.Couleur.NOIR, IPiece.Type.PION));
    }

    /**
     * Permet de tester si l'échiquier retourne la bonne pièce selon une position
     * dans l'échiquier.
     */
    public void testGetPiece() {
        // TODO Peut-être pas la meilleur facon de tester
        assertEquals(IPiece.Type.PION, m_echiquier.getPiece(new Position("d2")).getType());
        assertEquals(IPiece.Type.ROI, m_echiquier.getPiece(new Position("e1")).getType());
        assertEquals("c", m_echiquier.getPiece(new Position("b8")).getRepresentation() + "");
        assertEquals("T", m_echiquier.getPiece(new Position("h1")).getRepresentation() + "");
    }

    /**
     * Permet de tester la force d'une couleur sur l'échiquier selon
     * le nombre de pièce restante.
     */
    public void testForceEchiquier() {
        assertEquals(38.0, m_echiquier.getForceEchiquier(IPiece.Couleur.BLANC));
        assertEquals(38.0, m_echiquier.getForceEchiquier(IPiece.Couleur.NOIR));
    }

    /**
     * Permet de tester si l'emplacement d'une pièce est bonne après
     * l'avoir mis à une place désirée.
     */
    public void testPlacerPiece() {
        m_echiquier.placerPiece(IPiece.Type.FOU, IPiece.Couleur.NOIR, new Position("c5"));
        // L'axe des y (chiffre) est présentement l'inverse d'un échiquier traditionnel
        // --> Rangée du haut = 1 et rangée du bas = 8
        String echiquierAjout =
                        "TCFDRFCT\n" +
                        "PPPPPPPP\n" +
                        "XXXXXXXX\n" +
                        "XXXXXXXX\n" +
                        "XXFXXXXX\n" +
                        "XXXXXXXX\n" +
                        "pppppppp\n" +
                        "tcfdrfct";
        System.out.println();
        System.out.println(m_echiquier.toString());
        assertEquals(echiquierAjout, m_echiquier.toString());
    }
}
