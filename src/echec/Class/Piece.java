package echec.Class;

public class Piece implements IPiece {
    private Couleur m_couleur;
    private Type m_type;

    public Piece(Couleur p_couleur, Type p_type) {
        m_couleur = p_couleur;
        m_type = p_type;
    }

    @Override
    public Couleur getCouleur() {
        return m_couleur;
    }

    @Override
    public boolean estBlanc() {
        return m_couleur == Couleur.BLANC;
    }

    @Override
    public boolean estNoir() {
        return !estBlanc();
    }

    @Override
    public double getForce() {
        return m_type.getForce();
    }

    @Override
    public Character getRepresentation() {
        return (estBlanc()) ? m_type.getRepresentation() : Character.toUpperCase(m_type.getRepresentation());
}

    @Override
    public Type getType() {
        return m_type;
    }
}
