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
    private final Type m_type;

    /**
     * Enum représentant les type de pièce dans un échiquier.
     */
    public enum Type {
            PION('p', 1),
            CAVALIER('c', 2.5),
            FOU('f', 3),
            TOUR('t', 5),
            REINE('d', 9),
            ROI('r', 0);

            /**
             * Représentation graphique de la pièce lors
             * de l'affichage de l'échiquier
             */
            private final Character m_representation;
            private final double m_force;

            /**
             * Constructeur de base pour l'enum Type.
             * Prend en parametre la representation et la force
             * associe a la piece
             *
             * @param p_representation Representation en caractere du type de piece
             * @param p_force          Force associe au type de piece
             */
            Type(Character p_representation, double p_force) {
                m_representation = p_representation;
                m_force = p_force;
            }
        }

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
    protected Piece(Couleur p_couleur, Type p_type) {
        m_couleur = p_couleur;
        m_type = p_type;
    }

    public Type getType() {
        return m_type;
    }

    /**
     * Methode permettant d'obtenir le caractere representant
     * la pièce selon son type.
     *
     * @return Le caractere associe a la piece
     */
    public char getRepresentation() {
        return m_couleur == Couleur.BLANC ? m_type.m_representation : Character.toUpperCase(m_type.m_representation);
    }

    /**
     * Methode permettant de definir la force d'une
     * pièce selon son type.
     *
     * @return Sa force sous forme de double.
     */
    public double getForce() {
        return m_type.m_force;
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
     * Methode permettant d'obtenir le mouvement
     * de la piece.
     *
     * @return Le mouvement associer a la piece
     */
    public abstract Mouvement getMouvement();

    /**
     * Method utilisee pour comparer
     * deux piece ensembles.
     *
     * @return Hashcode generer
     */
    @Override
    public int hashCode() {
        return Objects.hash(m_couleur, m_type.m_representation);
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
            return piece.getCouleur() == getCouleur() && piece.getRepresentation() == getRepresentation();
        } else {
            return false;
        }
    }
}
