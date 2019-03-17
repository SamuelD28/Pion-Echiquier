package echec.classes;

public class Pion extends Piece {
    /**
     * Constructeur de piece prennant en parametre
     * la couleur.
     *
     * @param p_couleur Couleur du piece
     */
    private Pion(Couleur p_couleur) {
        super(p_couleur, 'p');
    }

    public static Pion creer(Couleur p_couleur) {
        return new Pion(p_couleur);
    }
}
