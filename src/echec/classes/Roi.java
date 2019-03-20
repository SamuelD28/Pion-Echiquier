package echec.classes;

import echec.classes.Mouvement.TypeMouvement;
import java.util.ArrayList;
import java.util.Arrays;

import static echec.classes.Mouvement.TypeMouvement.*;

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
    private Roi(Couleur p_couleur) {
        super(p_couleur, Type.ROI);
    }

    public static Roi creer(Couleur p_couleur) {
        return new Roi(p_couleur);
    }

    @Override
    public Mouvement getMouvement() {
        return m_mouvement;
    }
}
