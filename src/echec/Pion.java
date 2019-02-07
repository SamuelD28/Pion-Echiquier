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
    /** La position du pion sur l'échiquier */
    private String m_position;

    /**
     * Constructeur
     *
     * @param p_couleur La couleur du pion
     * @param p_position La position du pion sur l'échiquier
     */
    Pion(String p_couleur, String p_position) {
        m_couleur = p_couleur;
        m_position = p_position;
    }

    public String getCouleur() { return m_couleur; }

    public String getPosition() { return m_position; }
}
