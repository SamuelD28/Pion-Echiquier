package echec;

import junit.framework.TestCase;

public class TestEchiquier extends TestCase {

    public void testCreer() {

        Echiquier echiquier = new Echiquier();
        assertEquals(0, echiquier.getNombrePions());
    }


}
