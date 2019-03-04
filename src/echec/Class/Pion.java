package echec.Class;

import java.util.ArrayList;

import static echec.Class.Pion.Couleur.*;

/**
 * Pion de base
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Pion {
    /**
     * Enum représentant les couleurs qu'un pion peut avoir.
     */
    public enum Couleur {
        BLANC,
        NOIR
    }

    /**
     * Enum représentant les type de pièce dans un échiquier.
     */
    public enum Nom {
        PION,
        CAVALIER,
        FOU,
        TOUR,
        REINE,
        ROI
    }

    /**
     * Variables membres de la classes
     */
    private final Couleur m_couleur;
    private final Nom m_nom;
    private char m_representation;
    private Position m_position;

    /**
     * Constructeur permettant d'assigner la couleur
     * au pion.
     *
     * @param p_couleur La couleur du pion
     */
    private Pion(Couleur p_couleur, Nom p_nom, Position p_position) {
        m_couleur = p_couleur;
        m_nom = p_nom;
        assignerRepresentation();
        setPosition(p_position);
    }

    public static ArrayList<Pion> obtenirTousLesPions() {
        ArrayList<Pion> pieces = new ArrayList();

        pieces.add(new Pion(NOIR, Nom.TOUR, new Position("a1")));
        pieces.add(new Pion(NOIR, Nom.TOUR, new Position("h1")));
        pieces.add(new Pion(NOIR, Nom.CAVALIER, new Position("b1")));
        pieces.add(new Pion(NOIR, Nom.CAVALIER, new Position("g1")));
        pieces.add(new Pion(NOIR, Nom.FOU, new Position("c1")));
        pieces.add(new Pion(NOIR, Nom.FOU, new Position("f1")));
        pieces.add(new Pion(NOIR, Nom.REINE, new Position("d1")));
        pieces.add(new Pion(NOIR, Nom.ROI, new Position("e1")));

        char p = 'a';
        for (int i = 0; i < Echiquier.TAILLE_ECHIQUIER; i++) {
            pieces.add(new Pion(NOIR, Nom.PION, new Position(p + "2")));
            p++;
        }

        pieces.add(new Pion(BLANC, Nom.TOUR, new Position("a8")));
        pieces.add(new Pion(BLANC, Nom.TOUR, new Position("h8")));
        pieces.add(new Pion(BLANC, Nom.CAVALIER, new Position("b8")));
        pieces.add(new Pion(BLANC, Nom.CAVALIER, new Position("g8")));
        pieces.add(new Pion(BLANC, Nom.FOU, new Position("c8")));
        pieces.add(new Pion(BLANC, Nom.FOU, new Position("f8")));
        pieces.add(new Pion(BLANC, Nom.REINE, new Position("d8")));
        pieces.add(new Pion(BLANC, Nom.ROI, new Position("e8")));

        p = 'a';
        for (int i = 0; i < Echiquier.TAILLE_ECHIQUIER; i++) {
            pieces.add(new Pion(BLANC, Nom.PION, new Position(p + "7")));
            p++;
        }

        return pieces;
    }

    /**
     * Methode qui assigne la representation graphique de la pièce en
     * fonction de la couleur et de son nom de celui-ci.
     */
    private void assignerRepresentation() {
        switch (m_nom) {
            case PION: m_representation = 'p'; break;
            case CAVALIER: m_representation = 'c'; break;
            case FOU: m_representation = 'f'; break;
            case TOUR: m_representation = 't'; break;
            case REINE: m_representation = 'd'; break;
            case ROI: m_representation = 'r'; break;
            default:
            throw new IllegalArgumentException("Couleur inconnue");
        }

        if (m_couleur == NOIR) {
            m_representation = Character.toUpperCase(m_representation);
        }
    }

    private void setPosition(Position p_position) {
        m_position = p_position;
    }

    public Position getPosition() {
        return m_position;
    }

    public boolean estBlanc() {
        return m_couleur == BLANC;
    }

    public boolean estNoir() {
        return m_couleur == NOIR;
    }

    public char getRepresentation() {
        return m_representation;
    }

    public Couleur getCouleur() {
        return m_couleur;
    }
}
