package echec.classes;

/**
 * Classe de piece tour
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Tour extends Piece {
    /**
     * Constructeur de la tour prennant en parametre
     * la couleur.
     *
     * @param p_couleur Couleur de la tour
     */
    private Tour(Couleur p_couleur) {
        super(p_couleur, Type.TOUR);
    }

    public static Tour creer(Couleur p_couleur) {
        return new Tour(p_couleur);
    }
}
