package echec.Test;

import echec.Class.Echiquier;
import echec.Class.IPiece;
import echec.Class.Piece;
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
     * Test la création d'un échiquier
     */
    public void testCreer() {
        assertEquals(REPRESENTATION_DEPART, m_echiquier.toString());
        assertEquals(32, m_echiquier.getNombrePieces());
    }

    /**
     * Test l'ajout d'un pion dans un échiquier
     */
    public void testAjouterPion() {
        Piece pion = new Piece(IPiece.Couleur.BLANC, IPiece.Type.PION);
        assertTrue(m_echiquier.ajouterPion(pion, "a1"));
        assertEquals(1, m_echiquier.getNombrePions());
        assertEquals(pion, m_echiquier.getPion("a1"));
        assertEquals(BLANC, m_echiquier.getPion("a1").getCouleur());

        Pion pion2 = new Pion(NOIR);
        m_echiquier.ajouterPion(pion2, "b6");
        assertEquals(2, m_echiquier.getNombrePions());
        assertEquals(pion2, m_echiquier.getPion("b6"));
        assertEquals(NOIR, m_echiquier.getPion("b6").getCouleur());

        assertEquals(pion, m_echiquier.getPion("a1"));


        try {
            m_echiquier.ajouterPion(pion2, "zz");
        } catch (PositionInvalideException e) {
            assertEquals(ERR_POSITION_INVALIDE, e.getMessage());
            assertEquals(2, m_echiquier.getNombrePions());
        }
    }

    /**
     * Methode testant l'initialisation d'un echiquier. Vérifie
     * que les pièces sont bel et bien au bon endroit et que le
     * nombre de pièces correspond également.
     */
    public void testRepresentation() {

        System.out.println(m_echiquier.toString());

        //On teste le nombres de pions present sur l'echiquier
        assertEquals(32, m_echiquier.getNombrePions());
        //On teste la representation graphique de l'echiquier
        assertEquals(representationEhciquier, m_echiquier.toString());
    }

    public void testForceEchiquier() {

    }

    public void testPositionEchiquier() {

    }


}
