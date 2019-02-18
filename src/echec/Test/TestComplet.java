package echec.Test;

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
        suite.addTestSuite(TestPion.class);
        //Teste la classe echiquier
        suite.addTestSuite(TestEchiquier.class);
        //Teste la classe Position
        suite.addTestSuite(TestPosition.class);
        return suite;
    }
}
