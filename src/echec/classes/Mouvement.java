package echec.classes;

import java.util.ArrayList;

public class Mouvement {

    enum TypeMouvement{
        DIAGONALE,
        LATERAL,
        EN_L,
        NON_VALIDE
    }

    private final int m_pasMinimum;
    private final int m_pasMaximum;
    private final ArrayList<TypeMouvement> m_typeMouvement;
    private final boolean m_colisionActive;

    public Mouvement(int p_pasMaximum, ArrayList<TypeMouvement> p_typeMouvement) {
        this.m_pasMinimum = 1;
        this.m_pasMaximum = p_pasMaximum;
        this.m_typeMouvement = p_typeMouvement;
        this.m_colisionActive = false; ///temporaire
    }

    public boolean estValide(Mouvement p_mouvement)
    {
        boolean estValide;

        for(TypeMouvement typeMouvement : p_mouvement.m_typeMouvement)
        {
            estValide = m_typeMouvement.contains(typeMouvement);
            if(!estValide) return estValide;
        }

        estValide = p_mouvement.m_pasMaximum <= m_pasMaximum &&
                    p_mouvement.m_colisionActive == m_colisionActive;

        return estValide;
    }

    public static Mouvement calculer(Position p_depart, Position p_fin)
    {
        ArrayList<TypeMouvement> typesMouvement = new ArrayList<>();

        int differenceX =  Math.abs(p_depart.getX() - p_fin.getX());
        int differenceY = Math.abs(p_depart.getY() - p_fin.getY());
        int pasMaximum = differenceX + differenceY;

        if(differenceX == 0 || differenceY == 0)
            typesMouvement.add(TypeMouvement.LATERAL);
        else if((differenceX == 1 && differenceY == 2) || (differenceY == 1 && differenceX == 2))
            typesMouvement.add(TypeMouvement.EN_L);
        else if(differenceX > 0 && differenceY > 0 && differenceX == differenceY)
            typesMouvement.add(TypeMouvement.DIAGONALE);
        else
            typesMouvement.add(TypeMouvement.NON_VALIDE);

        return new Mouvement(pasMaximum, typesMouvement);
    }
}
