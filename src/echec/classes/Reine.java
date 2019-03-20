package echec.classes;

import java.util.ArrayList;
import java.util.Arrays;

import static echec.classes.Mouvement.TypeMouvement.DIAGONALE;
import static echec.classes.Mouvement.TypeMouvement.LATERAL;

/**
 * Classe de piece reine
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Reine extends Piece {
    private final Mouvement m_mouvement = new Mouvement(8, new ArrayList<>(Arrays.asList(DIAGONALE, LATERAL)));

    /**
     * Constructeur de la reine prennant en parametre
     * la couleur.
     *
     * @param p_couleur Couleur du reine
     */
    private Reine(Couleur p_couleur) {
        super(p_couleur, Type.REINE);
    }

    public static Reine creer(Couleur p_couleur) {
        return new Reine(p_couleur);
    }

    @Override
    public Mouvement getMouvement() {
        return m_mouvement;
    }
}
