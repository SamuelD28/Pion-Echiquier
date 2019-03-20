package echec.classes;

import java.util.ArrayList;
import java.util.Arrays;

import static echec.classes.Mouvement.TypeMouvement.EN_L;

/**
 * Classe de piece cavalier
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Cavalier extends Piece {
    private final Mouvement m_mouvement = new Mouvement(3, new ArrayList<>(Arrays.asList(EN_L)));

    /**
     * Constructeur de cavalier prennant en parametre
     * la couleur.
     *
     * @param p_couleur Couleur du cavalier
     */
    public Cavalier(Couleur p_couleur) {
        super(p_couleur, Type.CAVALIER);
    }

    @Override
    public Mouvement getMouvement() {
        return m_mouvement;
    }
}
