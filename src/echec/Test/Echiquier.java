package echec.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Echiquier de base permettant l'ajout de pion
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
public class Echiquier {

    /**
     * Liste de tous les pions dans l'échiquier
     */
    private LinkedHashMap<String, Pion> m_pions = new LinkedHashMap<>();
    private char[][] m_echiquier = new char[8][8];

    /**
     * Methode qui initialise l'echiquier avec des pieces vides
     * representer ave des X.
     */
    public void initialiser() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (y == 1) {
                    m_echiquier[y][x] = 'P';
                    //Temporaire, on la conserve en x/y parce uqe ne sait pas encore comment
                    //on vas garder la position
                    ajouterPion(new Pion(), String.valueOf(x) + String.valueOf(y));
                } else if (y == 6) {
                    m_echiquier[y][x] = 'p';
                    ajouterPion(new Pion(), String.valueOf(x) + String.valueOf(y));
                } else {
                    m_echiquier[y][x] = 'X';
                }
            }
        }
    }

    /**
     * Calcule le nombre de pion dans l'échiquier
     *
     * @return Le nombre de pion dans l'échiquier
     */
    public int getNombrePions() {
        return m_pions.size();
    }

    /**
     * Indique le pion à la position donnée
     *
     * @param p_position La position du pion désiré
     * @return Le pion à la position donnée
     */
    public Pion getPion(String p_position) {
        return m_pions.get(p_position);
    }

    /**
     * Permet d'ajouter un pion dans l'échiquier
     *
     * @param p_pion     Le pion à ajouter
     * @param p_position La position du pion qu'on ajoute
     */
    public void ajouterPion(Pion p_pion, String p_position) {
        m_pions.put(p_position, p_pion);
    }

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
