package echec.Class;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static echec.Class.Echiquier.TAILLE_ECHIQUIER;

/**
 * Classe permettant de gérer la position d'une pièce
 * sur l'échiquier.
 */
public class Position {

    //Constante utiliser pour mapper une lettre a une position dans un echiquier
    private final static List<Character> ECHELLE_POSITIONX = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');
    private int m_X;
    private int m_Y;

    /**
     * Constructeur prive utiliser par la classe pour
     * initialiser une nouvelle position dans l'echiquier.
     * Le constructeur est priver pour pouvoir permettre le
     * renvoi d'une valeur null au lieu de lever une exception
     * pour une position incorrecte.
     *
     * @param p_positionX Position sur la longeur de l'echiquier
     * @param p_positionY Position sur la largeur de l'echiquier
     */
    private Position(int p_positionX, int p_positionY) {
        m_Y = p_positionY;
        m_X = p_positionX;
    }

    /**
     * Methode statique permettant d'initialiser une
     * nouvelle position sur l'echiquier avec une coordonnee
     * textuelle. Voir code.
     *
     * @<code>
     *     Position position = Position.creer("A1");
     * </code>
     *
     * @param p_positionTextuelle Position sur l'echiquier represente de facon textuelle.
     * @return La nouvelle position ou null si les coordonnees sont incorrectes
     */
    @Nullable
    public static Position creer(String p_positionTextuelle) {

        int[] positionXY = parseTextuelleVersPositionXY(p_positionTextuelle);

        if (estDansLesLimites(positionXY)) {
            return new Position(positionXY[0], positionXY[1]);
        } else
            return null;
    }

    /**
     * Methode statique permettant d"initialiser une
     * nouvelle position sur l"echiquier avec une coordonnee
     * chiffrer. Voir code.
     *
     * @<code>
     *     Position position = Position.creer(0,5);
     * </code>
     *
     * @param p_positionX Position X sur la longeur de l'echiquier
     * @param p_positionY Position Y sur la largeur de l'echiquier
     * @return La nouvelle position ou null si les coordonnees sont incorrectes
     */
    @Nullable
    public static Position creer(int p_positionX, int p_positionY) {

        if (estDansLesLimites(p_positionX, p_positionY)) {
            return new Position(p_positionX, p_positionY);
        } else
            return null;
    }

    /**
     * Methode statique permettant de convertir une position
     * textuelle en position xy sur l"echiquier sous forme
     * de array.
     *
     * @param p_positionTextuelle Position textuelle a convertir
     * @return La position converti sous formes de array. [0] = x, [1] = y
     */
    @Nullable
    private static int[] parseTextuelleVersPositionXY(String p_positionTextuelle) {
        if (p_positionTextuelle.length() == 2) {

            int positionX = ECHELLE_POSITIONX.indexOf(Character.toUpperCase(p_positionTextuelle.charAt(0)));
            int positionY = Character.getNumericValue(p_positionTextuelle.charAt(1)) - 1; //On retire 1 parce l'echiquier est de 0 a 7

            return new int[]{positionX, positionY};
        } else
            return null;
    }

    /**
     * Methode statique permettant de savoir si une position
     * est dans les limites de la grille de l'echiquier.
     *
     * @param p_positionXY Position a verifier. [0] = x, [1] = y
     * @return Vrai si la position est conforme sinon faux.
     */
    private static boolean estDansLesLimites(int... p_positionXY) {

        if(p_positionXY == null)
            return false;

        return (p_positionXY[0] >= 0 && p_positionXY[0] < TAILLE_ECHIQUIER)
                &&
                (p_positionXY[1] >= 0 && p_positionXY[1] < TAILLE_ECHIQUIER);
    }

    /**
     * Methode permettant d'assigner la position
     * de linstance a une nouvelle position representer
     * sous forme textuelle
     *
     * @param p_positionTextuelle Position textuelle a assigner l'instance
     * @return Vrai si l'assignation a reussi sinon retourne faux.
     */
    public boolean Assigner (String p_positionTextuelle) {
        int[] positionXY = parseTextuelleVersPositionXY(p_positionTextuelle);

        if (estDansLesLimites(positionXY)) {
            m_X = positionXY[0];
            m_Y = positionXY[1];
            return true;
        } else
            return false;
    }

    /**
     * Methode permettant d'assigner la position
     * de l'instance a une nouvelle position representer
     * sous forme de coordonnees.
     *
     * @param p_positionXY Position coordonnee a assigner l'instance. [0] = x, [1] = y
     * @return Vrai si l'assignation a reussi sinon retourne faux.
     */
    public boolean Assigner(int... p_positionXY){
        if(estDansLesLimites(p_positionXY)){
            m_X = p_positionXY[0];
            m_Y = p_positionXY[1];
            return true;
        }
        else
            return false;
    }

    public int getX() {
        return m_X;
    }

    public int getY() {
        return m_Y;
    }

    /**
     * Methode generant le hash code pour l'instance.
     * Utiliser pour permettant la comparaison entre
     * deux objects de type Position
     *
     * @return Le hash code generer pour l'instance
     */
    @Override
    public int hashCode() {
        return Objects.hash(m_X, m_Y);
    }

    /**
     * Methdoe permettant de comparer deux objects
     * de type position pour savoir si les deux Position
     * sont equivalente
     *
     * @param obj Position a comparer la courante instance
     * @return Vrai si les deux Position sont equivalentes sinon faux.
     */
    @Override
    public boolean equals(Object obj) {

        if(this == obj)
            return true;

        if(!(obj instanceof Position))
            return false;

        Position position = (Position) obj;
        return (this.m_X == position.getX())
                &&
                (this.m_Y == position.getY());
    }
}
