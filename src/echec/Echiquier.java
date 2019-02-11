package echec;

import java.util.LinkedHashMap;

/**
 * Echiquier de base permettant l'ajout de pion
 *
 * @author Samuel Colassin
 * @author Samuel Dubé
 */
class Echiquier{
    /** Liste de tous les pions dans l'échiquier */
    private LinkedHashMap<String, Pion> m_pions = new LinkedHashMap<>();

    /**
     * Calcule le nombre de pion dans l'échiquier
     *
     * @return Le nombre de pion dans l'échiquier
     */
    int getNombrePions() {
        return m_pions.size();
    }

    /**
     * Indique le pion à la position donnée
     *
     * @param p_position La position du pion désiré
     * @return Le pion à la position donnée
     */
    Pion getPion(String p_position) {
        return m_pions.get(p_position);
    }

    /**
     * Permet d'ajouter un pion dans l'échiquier
     *
     * @param p_pion Le pion à ajouter
     * @param p_position La position du pion qu'on ajoute
     */
    void ajouterPion(Pion p_pion, String p_position) {
        m_pions.put(p_position, p_pion);
    }
}
