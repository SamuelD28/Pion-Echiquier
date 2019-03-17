package echec.classes;

import java.util.Objects;

/**
 * Pièce de base que peut contenir un échiquier.
 *
 * @author Samuel Dube
 * @author Samuel Colassin
 */
public abstract class Piece {
    private final Couleur m_couleur;
    private final char m_representation;

    //TODO TYPE serait Pertinant a préserver dans la classe??
    /**
     * Enum représentant les couleurs qu'un pion peut avoir.
     */
    public enum Couleur {
        BLANC,
        NOIR
    }

    /**
     * Constructeur de base prennant en parametre
     * la couleur et le type de piece.
     *
     * @param p_couleur Couleur de la piece
     */
    protected Piece(Couleur p_couleur, char p_representation) {
        m_couleur = p_couleur;
        m_representation = p_representation;
    }

    /**
     * Methode permettant d'obtenir le caractere representant
     * la pièce selon son type.
     *
     * @return Le caractere associe a la piece
     */
    public char getRepresentation() {
        return m_couleur == Couleur.BLANC ? m_representation : Character.toUpperCase(m_representation);
    }

    /**
     * Methode permettant de definir la force d'une
     * pièce selon son type.
     *
     * @return Sa force sous forme de double.
     */
    public double getForce() {
        switch (m_representation) {
            case 'r' : return 0;
            case 'd' : return 9;
            case 't' : return 5;
            case 'f' : return 3;
            case 'c' : return 2.5;
            case 'p' : return 1;
            default: return -1;
        }
    }

    /**
     * Methode permettant de savoir si la piece est noire
     *
     * @return Vrai si la piece est noire
     */
    public boolean estNoir() {
        return !estBlanc();
    }

    /**
     * Methode permettant de savoir si la piece est blanche
     *
     * @return Vrai si la piece est blanche
     */
    public boolean estBlanc() {
        return m_couleur == Couleur.BLANC;
    }

    /**
     * Methode permettant d'obtenir la couleur
     * de la piece.
     *
     * @return Couleur de la piece
     */
    public Couleur getCouleur() {
        return m_couleur;
    }

    /**
     * Method utilisee pour comparer
     * deux piece ensembles.
     *
     * @return Hashcode generer
     */
    @Override
    public int hashCode() {
        // TODO Hash correctement?
        return Objects.hash(m_couleur, m_representation);
    }

    /**
     * Methode comparant deux piece ensemble
     * pour determiner si elle sont pareils
     *
     * @param obj Object a comparer
     * @return Vrai si les deux piece sont pareils
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == null)
            return false;

        if (obj instanceof Piece) {
            Piece piece = (Piece) obj;
            // TODO ok?
            return piece.getCouleur() == getCouleur() && piece.getRepresentation() == getRepresentation();
        } else {
            return false;
        }
    }
}
