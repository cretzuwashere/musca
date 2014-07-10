package musca2;

import java.awt.Dimension;
import java.awt.Point;

public class Strategie1 implements IStrategie{

    private MuscaVie _musca;
    private Dimension _dimensiune;

    public Strategie1(MuscaVie musca, Dimension boundaries) {
        this._musca = musca;
        this._dimensiune = boundaries;
    }

    public void getRandomDirectieOrizontala() {
        if (_musca.getOrientare().getDirectieDreapta() == true) {
            if (_musca.getPozitie().x <= _dimensiune.getWidth() - 50) {
                _musca.setPozitie(new Point(_musca.getPozitie().x += (int) (Math.random() * 10), _musca.getPozitie().y));
            } else {
                _musca._orientare.setDirectieDreapta(false);
            }

        } else {
            if (_musca.getPozitie().x >= 0) {
                _musca.setPozitie(new Point(_musca.getPozitie().x -= (int) (Math.random() * 10), _musca.getPozitie().y));
            } else {
                _musca._orientare.setDirectieDreapta(true);
            }
        }
    }

    public void getRandomDirectieVerticala() {
        if (_musca.getOrientare().getDirectieSus() == true) {
            if (_musca.getPozitie().y <= _dimensiune.getHeight() - 50) {
                _musca.setPozitie(new Point(_musca.getPozitie().x, _musca.getPozitie().y += (int) (Math.random() * 10)));
            } else {
                _musca._orientare.setDirectieSus(false);
            }
        } else {
            if (_musca.getPozitie().y >= 0) {
                _musca.setPozitie(new Point(_musca.getPozitie().x, _musca.getPozitie().y -= (int) (Math.random() * 10)));
            } else {
                _musca._orientare.setDirectieSus(true);
            }
        }
    }

    public void aplicaStrategie() {
        double sansaOrizontal, sansaVertical;
        sansaOrizontal = Math.random() * 100;
        sansaVertical = Math.random() * 100;
        if (sansaOrizontal >= 85) {
            _musca._orientare.setDirectieDreapta(!_musca.getOrientare().getDirectieDreapta());
        }
        if (sansaVertical >= 85) {
            _musca._orientare.setDirectieSus(!_musca.getOrientare().getDirectieSus());
        }
        getRandomDirectieOrizontala();
        getRandomDirectieVerticala();
    }
}
