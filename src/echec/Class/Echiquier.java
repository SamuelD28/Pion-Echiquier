package echec.Class;

import echec.Class.Pion.Couleur;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Echiquier de base permettant l'ajout de pion
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Echiquier {
    final static int TAILLE_ECHIQUIER = 8;
    private final LinkedHashMap<Position, Pion> m_pions = new LinkedHashMap<>();
    private final char[][] m_echiquier = new char[TAILLE_ECHIQUIER][TAILLE_ECHIQUIER];

    /**
     * Methode qui initialise l'echiquier avec des pieces vides
     * representer ave des X.
     */
    public void initialiser() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                m_echiquier[y][x] = 'X';
            }
        }
    }

//    /**
//     * Methode TEMPORAIRE permettant de remplir une
//     * rangee de l'echiquier avec des pions.
//     *
//     * @param p_couleur Couleur des pions a ajouter
//     * @param p_range   Position de la rangee ou ajouter les pions
//     */
//    public void placerPions(Couleur p_couleur, int p_range) {
//        for (int positionX = 0; positionX < TAILLE_ECHIQUIER; positionX++) {
//            Position positionPion = new Position(positionX, p_range);
//            Pion pion = new Pion(p_couleur);
//            m_pions.put(positionPion, pion);
//            m_echiquier[positionPion.getY()][positionPion.getX()] = pion.getRepresentation();
//        }
//    }

    public void placerPieces() {
        ArrayList<Pion> pieces = Pion.obtenirTousLesPions();

        for (Pion piece: pieces) {
            m_pions.put(piece.getPosition(), piece);
            m_echiquier[piece.getPosition().getY()][piece.getPosition().getX()] = piece.getRepresentation();
        }
    }

    /**
     * Methode retournant le nombre de pions total de
     * l'échiquier courant.
     *
     * @return Le nombre de pion total dans l'échiquier.
     */
    public int getNombrePions() {
        return m_pions.size();
    }

    /**
     * Methode permettant d'obtenir la référence d'un pion
     * à une position donnée.
     *
     * @param p_position La position du pion désiré
     * @return Le pion à la position donnée
     */
    public Pion getPion(String p_position) {
        Position position = new Position(p_position);
        return m_pions.get(position);
    }

    /**
     * Permet d'ajouter un pion dans l'échiquier
     *
     * @param p_pion     Le pion à ajouter
     * @param p_position La position du pion qu'on ajoute
     */
    public boolean ajouterPion(Pion p_pion, String p_position) {
        try{
            Position position = new Position(p_position);
            m_pions.put(position, p_pion);
            return true;
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Methode permettant d'obtenir la représentation graphique
     * sous forme de string de l'échiquier.
     *
     * @return La string representant l'echiquier avec
     * les pièces qu'il contient.
     */
    @Override
    public String toString() {

        StringBuilder representationEchiquier = new StringBuilder();

        for (int x = 0; x < m_echiquier[0].length; x++) {
            for (int y = 0; y < m_echiquier[1].length; y++) {
                representationEchiquier.append(m_echiquier[x][y]);
            }
            representationEchiquier.append("\n");
        }

        return representationEchiquier.toString();
    }
}
