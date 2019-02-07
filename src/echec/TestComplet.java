package echec;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestComplet extends TestCase {
    public static TestSuite suite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(TestPion.class);
        suite.addTestSuite(TestEchiquier.class);
        return suite;
    }
}
