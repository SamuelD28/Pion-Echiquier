package echec.Test;

import echec.classes.Fou;
import echec.classes.Piece;

public class TestFou extends TestPiece {



    @Override
    protected Piece creerPiece(Piece.Couleur p_couleur) {
        return Fou.creer(p_couleur);
    }

    public void Assingation(){
        m_force
                m_rep

        testCouleur(Fou.creer(Piece.Couleur.BLANC), Piece.Couleur.BLANC);
    }



}
