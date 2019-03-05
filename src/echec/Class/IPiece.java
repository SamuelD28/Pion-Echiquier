package echec.Class;

public interface IPiece {

    /**
     * Enum représentant les type de pièce dans un échiquier.
     */
     enum Type {
        PION('p', 1),
        CAVALIER('c', 2.5),
        FOU('f', 3),
        TOUR('t', 5),
        REINE('d', 9),
        ROI('r', 0);

        private Character m_representation;
        private double m_force;

        Type(Character p_representation, double p_force)
        {
            m_representation = p_representation;
            m_force = p_force;
        }
        public double getForce(){return m_force;}
        public Character getRepresentation(){return m_representation;}
    }

    /**
     * Enum représentant les couleurs qu'un pion peut avoir.
     */
    enum Couleur {
        BLANC,
        NOIR
    }

    Couleur getCouleur();
    boolean estBlanc();
    boolean estNoir();
    double getForce();
    Character getRepresentation();
    Type getType();
}
