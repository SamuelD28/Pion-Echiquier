package echec.classes;

import java.util.ArrayList;
import java.util.Arrays;

import static echec.classes.Mouvement.TypeMouvement.DIAGONALE;
import static echec.classes.Mouvement.TypeMouvement.LATERAL;

/**
 * Classe de piece pion
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Pion extends Piece {
    private final Mouvement m_mouvement = new Mouvement(1, new ArrayList<>(Arrays.asList(DIAGONALE, LATERAL)));

    /**
     * Constructeur de piece prennant en parametre
     * la couleur.
     *
     * @param p_couleur Couleur du piece
     */
    public Pion(Couleur p_couleur) {
        super(p_couleur, Type.PION);
    }

    @Override
    public Mouvement getMouvement() {
        return m_mouvement;
    }
}
