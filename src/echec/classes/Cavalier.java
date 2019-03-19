package echec.classes;

/**
 * Classe de piece cavalier
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Cavalier extends Piece {
    /**
     * Constructeur de cavalier prennant en parametre
     * la couleur.
     *
     * @param p_couleur Couleur du cavalier
     */
    private Cavalier(Couleur p_couleur) {
        super(p_couleur, Type.CAVALIER);
    }

    public static Cavalier creer(Couleur p_couleur) {
        return new Cavalier(p_couleur);
    }
}
