package echec.classes;

import java.util.ArrayList;
import java.util.Arrays;

import static echec.classes.Mouvement.TypeMouvement.LATERAL;

/**
 * Classe de piece tour
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Tour extends Piece {
    private final Mouvement m_mouvement = new Mouvement(8, new ArrayList<>(Arrays.asList(LATERAL)));

    /**
     * Constructeur de la tour prennant en parametre
     * la couleur.
     *
     * @param p_couleur Couleur de la tour
     */
    public Tour(Couleur p_couleur) {
        super(p_couleur, Type.TOUR);
    }

    @Override
    public Mouvement getMouvement() {
        return m_mouvement;
    }
}
