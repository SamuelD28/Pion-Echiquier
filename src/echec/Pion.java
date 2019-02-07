package echec;

/**
 * Pion de base
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Pion {
    /** La couleur du pion */
    private String m_couleur;

    public Pion() {
        m_couleur = "blanc";
    }

    /**
     * Constructeur
     *
     * @param p_couleur La couleur du pion
     */
    Pion(String p_couleur) {
        m_couleur = p_couleur;
    }

    public String getCouleur() { return m_couleur; }
}
