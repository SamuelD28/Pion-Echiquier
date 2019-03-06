package echec.classes;

import java.util.Objects;

/**
 * Pièce de base que peut contenir un échiquier.
 *
 * @author Samuel Dube
 * @author Samuel Colassin
 */
public class Piece implements IPiece {
    private final Couleur m_couleur;
    private final Type m_type;

    /**
     * Constructeur de base prennant en parametre
     * la couleur et le type de piece.
     *
     * @param p_couleur Couleur de la piece
     * @param p_type    Type de la piece
     */
    public Piece(Couleur p_couleur, Type p_type) {
        m_couleur = p_couleur;
        m_type = p_type;
    }

    /**
     * Methode permettant d'obtenir le caractere representant
     * la pice.
     *
     * @return Le caractere associe a la piece
     */
    @Override
    public char getRepresentation() {
        return (estBlanc()) ? m_type.getRepresentation() : Character.toUpperCase(m_type.getRepresentation());
    }

    /**
     * Methode permettant d'obtenir la force de la piece.
     *
     * @return La force de la piece
     */
    @Override
    public double getForce() {
        return m_type.getForce();
    }

    /**
     * Methode permettant de savoir si la piece est noire
     *
     * @return Vrai si la piece est noire
     */
    @Override
    public boolean estNoir() {
        return !estBlanc();
    }

    /**
     * Methode permettant de savoir si la piece est blanche
     *
     * @return Vrai si la piece est blanche
     */
    @Override
    public boolean estBlanc() {
        return m_couleur == Couleur.BLANC;
    }

    /**
     * Methode permettant d"obtenir la couleur
     * de la piece.
     *
     * @return Couleur de la piece
     */
    @Override
    public Couleur getCouleur() {
        return m_couleur;
    }

    /**
     * Methode permettant d'obtenir le type de la piece.
     *
     * @return Type de la piece
     */
    @Override
    public Type getType() {
        return m_type;
    }

    /**
     * Method utilisee pour comparer
     * deux piece ensembles.
     *
     * @return Hashcode generer
     */
    @Override
    public int hashCode() {
        return Objects.hash(m_type, m_couleur);
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

        if (obj instanceof IPiece) {
            IPiece piece = (IPiece) obj;
            return piece.getCouleur() == getCouleur() && piece.getType() == getType();
        } else {
            return false;
        }
    }
}
