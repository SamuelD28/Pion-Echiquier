package echec;

import java.util.LinkedHashMap;

public class Echiquier{

    private LinkedHashMap<String, Pion> m_pions = new LinkedHashMap<String, Pion>();

    public Echiquier() {
    }

    public int getNombrePions() {
        return m_pions.size();
    }
}
