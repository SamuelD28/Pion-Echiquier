package echec.classes;

import java.util.ArrayList;
import java.util.Arrays;

import static echec.classes.Mouvement.TypeMouvement.DIAGONALE;

/**
 * Classe de piece fou
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Fou extends Piece {
    private final Mouvement m_mouvement = new Mouvement(8, new ArrayList<>(Arrays.asList(DIAGONALE)));

    /**
     * Constructeur de fou prennant en parametre
     * la couleur.
     *
     * @param p_couleur Couleur du fou
     */
    public Fou(Couleur p_couleur) {
        super(p_couleur, Type.FOU);
    }

    @Override
    public Mouvement getMouvement() {
        return m_mouvement;
    }
}
