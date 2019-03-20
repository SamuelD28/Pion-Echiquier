package echec.classes;

import java.util.ArrayList;

/**
 * Classe permettant de gerer les mouvements
 * relatifs aux pieces.
 *
 * @author Samuel Colassin
 * @author Samuel Dube
 */
public class Mouvement {
    /**
     * Enum permettant de specifier quel type
     * de mouvement est accepter pour la piece
     */
    public enum TypeMouvement {
        DIAGONALE,
        LATERAL,
        EN_L,
        NON_VALIDE
    }

    private final int m_pasMinimum;
    private final int m_pasMaximum;
    private final ArrayList<TypeMouvement> m_typesMouvement;
    private final boolean m_colisionActive;

    /**
     * Constructeur permettant de creer une nouvelle
     * configuration de mouvement
     *
     * @param p_pasMaximum    Nombre de pas maximum alloue
     * @param p_typeMouvement Listes de type de mouvement alloue
     */
    public Mouvement(int p_pasMaximum, ArrayList<TypeMouvement> p_typeMouvement) {
        this.m_pasMinimum = 1;
        this.m_pasMaximum = p_pasMaximum;
        this.m_typesMouvement = p_typeMouvement;
        this.m_colisionActive = false; ///temporaire. A implementer plus tard
    }

    /**
     * Methode permettant de verifier que le mouvement demande
     * est conforme a la configuratino de mouvement associer.
     *
     * @param p_mouvement Mouvement a verifier
     * @return Vrai si le mouvement peut etre effectuer
     */
    public boolean estValide(Mouvement p_mouvement) {
        boolean estValide;

        for (TypeMouvement typeMouvement : p_mouvement.m_typesMouvement) {
            estValide = m_typesMouvement.contains(typeMouvement);
            if (!estValide) return false;
        }

        estValide = p_mouvement.m_pasMaximum <= m_pasMaximum &&
                p_mouvement.m_pasMinimum >= m_pasMinimum &&
                p_mouvement.m_colisionActive == m_colisionActive;

        return estValide;
    }

    /**
     * Methode permettant de calculer le mouvement demande
     * en se basant sur deux positions donnes.
     *
     * @param p_depart Position de depart
     * @param p_fin    Position de fin
     * @return Le mouvement calculer
     */
    public static Mouvement calculer(Position p_depart, Position p_fin) {
        ArrayList<TypeMouvement> typesMouvement = new ArrayList<>();

        int differenceX = Math.abs(p_depart.getX() - p_fin.getX());
        int differenceY = Math.abs(p_depart.getY() - p_fin.getY());
        int pasMaximum = differenceX + differenceY;

        if (differenceX == 0 || differenceY == 0)
            typesMouvement.add(TypeMouvement.LATERAL);
        else if ((differenceX == 1 && differenceY == 2) || (differenceY == 1 && differenceX == 2))
            typesMouvement.add(TypeMouvement.EN_L);
        else if (differenceY > 0 && differenceX == differenceY) {
            pasMaximum = differenceX;
            typesMouvement.add(TypeMouvement.DIAGONALE);
        } else
            typesMouvement.add(TypeMouvement.NON_VALIDE);

        return new Mouvement(pasMaximum, typesMouvement);
    }

    public int getPasMinimum() {
        return m_pasMinimum;
    }

    public int getPasMaximum() {
        return m_pasMaximum;
    }

    public ArrayList<TypeMouvement> getTypesMouvement() {
        return m_typesMouvement;
    }
}
