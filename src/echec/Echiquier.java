package echec;

import java.util.LinkedHashMap;

public class Echiquier{

    private LinkedHashMap<String, Pion> m_pions = new LinkedHashMap<>();

    public int getNombrePions() {
        return m_pions.size();
    }

    public void ajouterPion(Pion p_pion, String p_position) {
        m_pions.put(p_position, p_pion);
    }

    public Pion getPion(String p_position) {
        return m_pions.get(p_position);
    }
}
