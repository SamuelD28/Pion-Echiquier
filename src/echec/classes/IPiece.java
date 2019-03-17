//package echec.classes;
//
///**
// * Interface pour les pièces d'un échiquier
// *
// * @author Samuel Dube
// * @author Samuel Colassin
// */
//public interface IPiece {
//    /**
//     * Enum représentant les type de pièce dans un échiquier.
//     */
//    enum Type {
//        PION('p', 1),
//        CAVALIER('c', 2.5),
//        FOU('f', 3),
//        TOUR('t', 5),
//        REINE('d', 9),
//        ROI('r', 0);
//
//        /**
//         * Représentation graphique de la pièce lors
//         * de l'affichage de l'échiquier
//         */
//        private final Character m_representation;
//        private final double m_force;
//
//        /**
//         * Constructeur de base pour l'enum Type.
//         * Prend en parametre la representation et la force
//         * associe a la piece
//         *
//         * @param p_representation Representation en caractere du type de piece
//         * @param p_force Force associe au type de piece
//         */
//        Type(Character p_representation, double p_force) {
//            m_representation = p_representation;
//            m_force = p_force;
//        }
//
//        /**
//         * Methode permettant d'obtenir la force associe
//         * a un type de piece
//         *
//         * @return La force du type de piece
//         */
//        double getForce() {
//            return m_force;
//        }
//
//
//        /**
//         * Methode permettant d'obtenir le caractere associe
//         * au type de piece.
//         *
//         * @return Caractere associe au type de piece
//         */
//        Character getRepresentation() {
//            return m_representation;
//        }
//    }
//
//    /**
//     * Enum représentant les couleurs qu'un pion peut avoir.
//     */
//    enum Couleur {
//        BLANC,
//        NOIR
//    }
//
//    /**
//     * Methode permettant d"obtenir la couleur
//     * de la piece.
//     *
//     * @return Couleur de la piece
//     */
//    Couleur getCouleur();
//
//    /**
//     * Methode permettant de savoir si la piece est blanche.
//     *
//     * @return Vrai si elle est blanche
//     */
//    boolean estBlanc();
//
//    /**
//     * Methode permettant de savoir si la piece est noir.
//     *
//     * @return Vrai si la piece est noir
//     */
//    boolean estNoir();
//
//    /**
//     * Methode permettant d'obtenir la force de la piece.
//     *
//     * @return La force de la piece
//     */
//    double getForce();
//
//
//    /**
//     * Methode permettant d'obtenir le caractere representant
//     * la pice.
//     *
//     * @return Le caractere associe a la piece
//     */
//    char getRepresentation();
//
//
//    /**
//     * Methode permettant d'obtenir le type de la piece.
//     *
//     * @return Type de la piece
//     */
//    Type getType();
//}
