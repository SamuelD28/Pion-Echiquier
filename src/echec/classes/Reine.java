package echec.classes;

/**
 * Classe de piece reine
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Reine extends Piece {
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
}
