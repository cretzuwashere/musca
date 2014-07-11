package musca2;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

public abstract class Musca implements IMusca {

    protected Image _musca;
    protected Point _pozitie;
    protected Image _pozaMusca;
    public Orientare _orientare;

    public Musca(Image x, Point z) {
        _musca = x;
        _pozitie = z;
    }

    @Override
    public Point getPozitie() {
        return _pozitie;
    }

    @Override
    public void setPozitie(Point x) {
        _pozitie = x;
    }

    @Override
    public Image getPoza() {
        return _pozaMusca;
    }

    @Override
    public Orientare getOrientare() {
        return _orientare;
    }

    @Override
    public void setOrientare(Orientare x) {
        _orientare = x;
    }

    @Override
    public abstract void aplicaStrategie(Dimension boundaries);
}
