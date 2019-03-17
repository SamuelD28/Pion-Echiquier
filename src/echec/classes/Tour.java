package echec.classes;

public class Tour extends Piece {
    /**
     * Constructeur de la tour prennant en parametre
     * la couleur.
     *
     * @param p_couleur Couleur de la tour
     */
    private Tour(Couleur p_couleur) {
        super(p_couleur, 't');
    }

    public static Tour creer(Couleur p_couleur) {
        return new Tour(p_couleur);
    }
}
