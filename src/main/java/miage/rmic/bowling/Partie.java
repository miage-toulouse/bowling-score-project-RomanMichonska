package miage.rmic.bowling;

import java.util.ArrayList;
import java.util.List;

public class Partie {

    private List<Jeu> jeux = new ArrayList<>();

    public Partie(Jeu leJeu) {
        for(int i = 0; i < 10 ; i++){
            jeux.add(leJeu);
        }
        if (jeux.get(9).isSpare()){
            jeux.add(leJeu);
        }
        if (jeux.get(9).isStrike()){
            jeux.add(leJeu);
            jeux.add(leJeu);
        }
    }

    public Integer calculeScore() {
        Integer score = 0;
        for(int i = 0; i < 10 ; i++){
            Jeu jeuCourant = jeux.get(i);
            score += jeuCourant.nombreQuillesTombees();
            if (jeuCourant.isSpare()){
                score += jeux.get(i+1).nombreQuillesTombeesLancer1();
            }
            if (jeuCourant.isStrike()){
                score += jeux.get(i+1).nombreQuillesTombeesLancer1() + jeux.get(i+2).nombreQuillesTombeesLancer1();
            }
        }
        return score;
    }
}
