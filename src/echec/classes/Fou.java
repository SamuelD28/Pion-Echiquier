package echec.classes;

/**
 * Classe de piece fou
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Fou extends Piece {
    /**
     * Constructeur de fou prennant en parametre
     * la couleur.
     *
     * @param p_couleur Couleur du fou
     */
    private Fou(Couleur p_couleur) {
        super(p_couleur, Type.FOU);
    }

    public static Fou creer(Couleur p_couleur) {
        return new Fou(p_couleur);
    }
}
