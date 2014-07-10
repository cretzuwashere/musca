package musca2;

import java.awt.Image;
import java.awt.Point;

public class Musca {

    protected Image _musca;
    protected Point _pozitie;
    protected Image _pozaMusca;
    public Orientare _orientare;

    public Musca(Image x, Point z) {
        _musca = x;
        _pozitie = z;
    }
    ;
    
    public Point getPozitie() {
        return _pozitie;
    }

    public void setPozitie(Point x) {
        _pozitie = x;
    }

    public Image getPoza() {
        return _pozaMusca;
    }

    public Orientare getOrientare() {
        return _orientare;
    }

    public void setOrientare(Orientare x) {
        _orientare = x;
    }
}
