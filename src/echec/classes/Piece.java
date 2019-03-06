package echec.classes;

/**
 * Pièce de base que peut contenir un échiquier
 *
 * @author Samuel Dube
 * @author Samuel Colassin
 */
public class Piece implements IPiece {
    private final Couleur m_couleur;
    private final Type m_type;

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
    public char getRepresentation() {
        return (estBlanc()) ? m_type.getRepresentation() : Character.toUpperCase(m_type.getRepresentation());
    }

    @Override
    public Type getType() {
        return m_type;
    }

    @Override
    public int hashCode() {
        return (int)m_type.getForce() * 31 + m_couleur.ordinal() * 31;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null)
            return false;

        if(obj instanceof IPiece)
        {
            IPiece piece = (IPiece)obj;
            return piece.getCouleur() == getCouleur() && piece.getType() == getType();
        }
        else{
            return false;
        }
    }
}
