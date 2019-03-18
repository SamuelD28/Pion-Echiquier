package echec.test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Regroupe tous les tests du package echec
 *
 * @author Samuel Dubé
 * @author Samuel Colassin
 */
public class TestComplet extends TestCase {
    /**
     * Créer et ajoute les tests du package echec dans une suite
     *
     * @return la suite avec les tests à effectuer
     */
    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        //Teste la classe Pion
        //suite.addTestSuite(TestPiece.class);
        //Teste la classe echiquier
        suite.addTestSuite(TestEchiquier.class);
        //Teste la classe Position
        suite.addTestSuite(TestPosition.class);
        suite.addTestSuite(TestPion.class);
        suite.addTestSuite(TestTour.class);
        suite.addTestSuite(TestCavalier.class);
        suite.addTestSuite(TestFou.class);
        suite.addTestSuite(TestReine.class);
        suite.addTestSuite(TestRoi.class);
        return suite;
    }
}
