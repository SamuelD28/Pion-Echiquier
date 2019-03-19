package echec.classes;

/**
 * Classe de piece roi
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Roi extends Piece {
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
}
