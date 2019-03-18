package echec.classes;

import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

import static echec.classes.Piece.Couleur;
import static echec.classes.Piece.Type;
import static echec.classes.Piece.Couleur.BLANC;
import static echec.classes.Piece.Couleur.NOIR;

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
                        m_echiquier.put(new Position(x, y), obtenirPiecePositionDepart(x, NOIR));
                        break;
                    case 1:
                        m_echiquier.put(new Position(x, y), Pion.creer(NOIR));
                        break;
                    case 6:
                        m_echiquier.put(new Position(x, y), Pion.creer(BLANC));
                        break;
                    case 7:
                        m_echiquier.put(new Position(x, y), obtenirPiecePositionDepart(x, BLANC));
                        break;
                    default:
                        m_echiquier.put(new Position(x, y), null);
                        break;
                }
            }
        }
    }

    //TODO Changer ou garder un type?
    /**
     * Permet d'obtenir la pièce à mettre sur l'échiquier
     * selon la position dans celui-ci.
     *
     * @param x L'axe des x dans l'échiquier
     * @return Le type de pièce à mettre dans l'échiquier
     */
    private static Piece obtenirPiecePositionDepart(int x, Couleur p_couleur) {
        switch (x) {
            case 0:
            case 7:
                return Tour.creer(p_couleur);
            case 1:
            case 6:
                return Cavalier.creer(p_couleur);
            case 2:
            case 5:
                return Fou.creer(p_couleur);
            case 3:
                return Reine.creer(p_couleur);
            case 4:
                return Roi.creer(p_couleur);
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Permet d'avoir le nombre d'occurence d'une pièce dans l'échiquier courant
     *
     * @param p_couleur la couleur de la pièce désirée
     * @param p_type    le type de la pièce désirée
     * @return le nombre d'occurence de la pièce dans le jeu
     */
    public int getNombrePieces(Couleur p_couleur, Type p_type) {
        //On fait un cast en int puisque on sait que le nombre total ne depassera jamais un int
        return (int) m_echiquier
                .values()
                .stream()
                .filter(o -> o instanceof Piece)
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
                .filter(o -> o instanceof Piece)
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
                .filter(p -> p instanceof Piece && ((Piece) p).getCouleur() == p_couleur)
                .mapToDouble(p -> ((Piece) p).getForce())
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
    public Piece getPiece(Position p_position) {
        Object obj = m_echiquier.get(p_position);
        return obj instanceof Piece ? ((Piece) obj) : null;
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
        int rangeeDepart = 0;

        for (Map.Entry<Position, Object> result : m_echiquier.entrySet()) {

            Object valeur = result.getValue();
            Position cle = result.getKey();

            //Ajoute un saut de ligne quand on change de rangee
            if (cle.getY() != rangeeDepart) {
                rangeeDepart++;
                representationEchiquier.append('\n');
            }

            if (valeur instanceof Piece) {
                representationEchiquier.append(((Piece) valeur).getRepresentation());
            } else {
                representationEchiquier.append('X');
            }
        }
        return representationEchiquier.toString();
    }

    /**
     * Permet de placer une pièce à un endroit
     * désiré dans l'échiquier.
     *
     * @param p_piece            Piece a deplacer sur l'echiquier
     * @param p_nouvellePosition la position où on veut mettre la pièce
     */
    public boolean placerPiece(Piece p_piece, Position p_nouvellePosition) {
        //Pour linstant on retourne false si une piece est deja a la position souhaite
        if (m_echiquier.get(p_nouvellePosition) != null)
            return false;
        //NOTE : On doit faire un distinction entre deux piece de meme type/couleur.
        var result = m_echiquier.entrySet()
                .stream()
                .filter(p -> p.getValue() instanceof Piece && p.getValue().equals(p_piece))
                .findFirst();

        if (result.isPresent()) {

            Position anciennePosition = result.get().getKey();
            Piece piece = (Piece) result.get().getValue();

            m_echiquier.replace(anciennePosition, null);
            m_echiquier.replace(p_nouvellePosition, piece);
            return true;
        }

        return false;
    }
}
