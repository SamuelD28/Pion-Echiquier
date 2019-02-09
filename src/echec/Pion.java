package echec;

/**
 * Pion de base
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
class Pion {
    private String m_couleur;

    /**
     * Constructeur
     *
     * @param p_couleur La couleur du pion
     */
    Pion(String p_couleur) {
        m_couleur = p_couleur;
    }

    /**
     * Constructeur sans paramètre avec une couleur par défaut
     */
    Pion() {
        m_couleur = "blanc";
    }

    String getCouleur() {
        return m_couleur;
    }
}
