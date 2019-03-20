package echec.classes;

import java.util.ArrayList;
import java.util.Arrays;

import static echec.classes.Mouvement.TypeMouvement.DIAGONALE;
import static echec.classes.Mouvement.TypeMouvement.LATERAL;

/**
 * Classe de piece roi
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Roi extends Piece {
    private final Mouvement m_mouvement = new Mouvement(1, new ArrayList<>(Arrays.asList(DIAGONALE, LATERAL)));

    /**
     * Constructeur de roi prennant en parametre
     * la couleur.
     *
     * @param p_couleur Couleur du roi
     */
    public Roi(Couleur p_couleur) {
        super(p_couleur, Type.ROI);
    }

    @Override
    public Mouvement getMouvement() {
        return m_mouvement;
    }
}
