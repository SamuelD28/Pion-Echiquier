package echec.Test;

import static echec.Test.Pion.Couleur.*;

/**
 * Pion de base
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Pion {

    //On vas surment extraire sa dans une classe parente plus tard//
    public enum Couleur {
        BLANC,
        NOIR
    }

    /**
     * Variables membres de la classes
     */
    private Couleur m_couleur;
    private char m_representation;

    /**
     * Constructeur permettant d'assigner la couleur
     * au pion.
     *
     * @param p_couleur La couleur du pion
     */
    public Pion(Couleur p_couleur) {
        m_couleur = p_couleur;
        assignerRepresentation(p_couleur);
    }

    /**
     * Constructeur sans paramètre avec une couleur par défaut
     */
    public Pion() {
        m_couleur = BLANC;
        assignerRepresentation(BLANC);
    }

    /**
     * Methode qui assigne la representation graphique du pion en
     * fonction de la couleur de celui-ci.
     *
     * @param p_couleur Couleur assigner au pion
     */
    private void assignerRepresentation(Couleur p_couleur) {

        switch (p_couleur) {
            case BLANC:
                m_representation = 'p';
                break;
            case NOIR:
                m_representation = 'P';
                break;
            default:
                throw new IllegalArgumentException("Couleur inconnue");
        }
    }

    public char getRepresentation() {
        return m_representation;
    }

    public Couleur getCouleur() {
        return m_couleur;
    }
}
