package echec.classes;

import org.jetbrains.annotations.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;

import static echec.classes.IPiece.Couleur;
import static echec.classes.IPiece.Couleur.BLANC;
import static echec.classes.IPiece.Couleur.NOIR;
import static echec.classes.IPiece.Type;

/**
 * Echiquier de base permettant l'ajout de pion
 *
 * @author Samuel Colassin
 * @author Samuel Dube
 */
public class Echiquier {
    final static int TAILLE_ECHIQUIER = 8;
    private final LinkedHashMap<Position, Object> m_echiquier = new LinkedHashMap<>();

    public Echiquier() {
        initialiser();
    }

    /**
     * Methode qui initialise l'echiquier avec des m_echiquier vides
     * representer ave des X.
     */
    private void initialiser() {
        for (int y = 0; y < TAILLE_ECHIQUIER; y++) {
            for (int x = 0; x < TAILLE_ECHIQUIER; x++) {
                switch (y) {
                    case 0:
                        m_echiquier.put(new Position(x, y), Piece.obtenirPiece(NOIR, obtenirTypePositionDepart(x)));
                        break;
                    case 1:
                        m_echiquier.put(new Position(x, y), Piece.obtenirPiece(NOIR, Type.PION));
                        break;
                    case 6:
                        m_echiquier.put(new Position(x, y), Piece.obtenirPiece(BLANC, Type.PION));
                        break;
                    case 7:
                        m_echiquier.put(new Position(x, y), Piece.obtenirPiece(BLANC, obtenirTypePositionDepart(x)));
                        break;
                    default:
                        m_echiquier.put(new Position(x, y), null);
                        break;
                }
            }
        }
    }

    /**
     * Permet d'obtenir la pièce à mettre sur l'échiquier
     * selon la position dans celui-ci.
     *
     * @param x L'axe des x dans l'échiquier
     * @return Le type de pièce à mettre dans l'échiquier
     */
    private static Type obtenirTypePositionDepart(int x) {
        switch (x) {
            case 0:
                return Type.TOUR;
            case 1:
                return Type.CAVALIER;
            case 2:
                return Type.FOU;
            case 3:
                return Type.REINE;
            case 4:
                return Type.ROI;
            case 5:
                return Type.FOU;
            case 6:
                return Type.CAVALIER;
            case 7:
                return Type.TOUR;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Permet d'avoir le nombre d'occurence d'une pièce dans l'échiquier courant
     *
     * @param p_couleur la couleur de la pièce désirée
     * @param p_type le type de la pièce désirée
     * @return le nombre d'occurence de la pièce dans le jeu
     */
    public int getNombrePieces(Couleur p_couleur, Type p_type) {
        //On fait un cast en int puisque on sait que le nombre total ne depassera jamais un int
        return (int) m_echiquier
                .values()
                .stream()
                .filter(o -> o instanceof IPiece)
                .filter(p -> ((Piece) p).getCouleur() == p_couleur && ((Piece) p).getType() == p_type)
                .count();
    }

    /**
     * Permet d'avoir le nombre total de pièce dans l'échiquier courant
     *
     * @return Le nombre de pièce total de l'échiquer
     */
    public int getNombrePieces() {
        //On fait un cast en int puisque on sait que le nombre total ne depassera jamais un int
        return (int) m_echiquier
                .values()
                .stream()
                .filter(o -> o instanceof IPiece)
                .count();
    }

    /**
     * Permet d'avoir la force total de toutes les pièces de l'échiquier
     *
     * @return la force du jeu courant
     */
    public double getForceEchiquier(Couleur p_couleur) {
        return m_echiquier
                .values()
                .stream()
                .filter(p -> p instanceof IPiece)
                .filter(p -> ((IPiece) p).getCouleur() == p_couleur)
                .mapToDouble(p -> ((IPiece) p).getForce())
                .sum();
    }

    /**
     * Methode permettant d'obtenir la référence d'un pion
     * à une position donnée.
     *
     * @param p_position La position du pion désiré
     * @return Le pion à la position donnée
     */
    @Nullable
    public IPiece getPiece(Position p_position) {
        Object obj = m_echiquier.get(p_position);
        if (obj instanceof IPiece)
            return (IPiece) obj;
        else
            return null;
    }

    public boolean deplacerPiece(IPiece piece, Position p_position){}

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
        int rangeeDepart = 0;

        for (Map.Entry<Position, Object> entree : m_echiquier.entrySet()) {

            Object valeur = entree.getValue();
            Position cle = entree.getKey();

            //Ajoute un saut de ligne quand on change de rangee
            if (cle.getY() != rangeeDepart) {
                rangeeDepart++;
                representationEchiquier.append('\n');
            }

            if (valeur instanceof IPiece) {
                representationEchiquier.append(((IPiece) valeur).getRepresentation());
            } else {
                representationEchiquier.append('X');
            }
        }
        return representationEchiquier.toString();
    }

    //TODO Méthode pour placer une pièce dans l'échiquier
    // peut-être pas aussi simple que ca en réalité, mais effectue
    // ce qui est demandé dans l'énoncé
    /**
     * Permet de placer une pièce à un endroit
     * désiré dans l'échiquier
     *
     * @param p_type le type de la pièce
     * @param p_couleur la couleur de la pièce
     * @param p_position la position où on veut mettre la pièce
     */
    public void placerPiece(Type p_type, Couleur p_couleur, Position p_position) {
        m_echiquier.put(p_position, Piece.obtenirPiece(p_couleur, p_type));
    }
}
