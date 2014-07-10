
package musca2;

import java.awt.Dimension;
import java.awt.Point;

public class Strategie2 implements IStrategie {
    MuscaVie _musca;
    Dimension _limite;
    public Strategie2(MuscaVie musca ,Dimension boundaries){
        _musca = musca;
        _limite = boundaries;
    }
    
    public void directieOrizontala(){
         if (_musca.getOrientare().getDirectieDreapta() == true) {
            if (_musca.getPozitie().x <= _limite.getWidth() - 50) {
                _musca.setPozitie(new Point(_musca.getPozitie().x += 3, _musca.getPozitie().y));
            } else {
                _musca._orientare.setDirectieDreapta(false);
            }

        } else {
            if (_musca.getPozitie().x >= 0) {
                _musca.setPozitie(new Point(_musca.getPozitie().x -= 3, _musca.getPozitie().y));
            } else {
                _musca._orientare.setDirectieDreapta(true);
            }
        }
    }
    public void directieVerticala(){
         if (_musca.getOrientare().getDirectieSus() == true) {
            if (_musca.getPozitie().y <= _limite.getHeight() - 50) {
                _musca.setPozitie(new Point(_musca.getPozitie().x, _musca.getPozitie().y += 3));
            } else {
                _musca._orientare.setDirectieSus(false);
            }
        } else {
            if (_musca.getPozitie().y >= 0) {
                _musca.setPozitie(new Point(_musca.getPozitie().x, _musca.getPozitie().y -= 3));
            } else {
                _musca._orientare.setDirectieSus(true);
            }
        }
    }
    
    public void aplicaStrategie(){
        directieOrizontala();
        directieVerticala();
    }
    
    
}
