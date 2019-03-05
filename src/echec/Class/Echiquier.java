package echec.Class;

import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

import static echec.Class.IPiece.*;
import static echec.Class.IPiece.Couleur.BLANC;
import static echec.Class.IPiece.Couleur.NOIR;

/**
 * Echiquier de base permettant l'ajout de pion
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
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
                if (y == 0) {
                    m_echiquier.put(new Position(x, y), new Piece(NOIR, obtenirTypePositionDepart(x)));
                } else if (y == 1) {
                    m_echiquier.put(new Position(x, y), new Piece(NOIR, Type.PION));
                } else if (y == 6) {
                    m_echiquier.put(new Position(x, y), new Piece(BLANC, Type.PION));
                } else if (y == 7) {
                    m_echiquier.put(new Position(x, y), new Piece(BLANC, obtenirTypePositionDepart(x)));
                } else {
                    m_echiquier.put(new Position(x, y), null);
                }
            }
        }
    }

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
     * Methode retournant le nombre de pions total de
     * l'échiquier courant.
     *
     * @return Le nombre de pion total dans l'échiquier.
     */
    public int getNombrePieces(Couleur p_couleur, Type p_type) {
        //On fait un cast en int puisque on sait que le nombre total ne depasseras jamais un int
        return (int) m_echiquier
                .values()
                .stream()
                .filter(o -> o instanceof IPiece)
                .filter(p -> ((Piece) p).getCouleur() == p_couleur && ((Piece) p).getType() == p_type)
                .count();
    }

    public int getNombrePieces() {
        //On fait un cast en int puisque on sait que le nombre total ne depasseras jamais un int
        return (int) m_echiquier
                .values()
                .stream()
                .filter(o -> o instanceof IPiece)
                .count();
    }

    public double getForceEchiquier() {
        return m_echiquier
                .values()
                .stream()
                .filter(p -> p instanceof IPiece)
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
        int pointdepart = 0;

        for (Map.Entry<Position, Object> entree : m_echiquier.entrySet()) {

            Object valeur = entree.getValue();
            Position cle = entree.getKey();

            //Ajoute un saut de ligne quand on change de rangee
            if (cle.getY() != pointdepart) {
                pointdepart++;
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
}
