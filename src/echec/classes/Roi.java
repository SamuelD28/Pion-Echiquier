package echec.classes;

public class Roi extends Piece {
    /**
     * Constructeur de roi prennant en parametre
     * la couleur.
     *
     * @param p_couleur Couleur du roi
     */
    private Roi(Couleur p_couleur) {
        super(p_couleur, 'r');
    }

    public static Roi creer(Couleur p_couleur) {
        return new Roi(p_couleur);
    }
}
