package musca2;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

public class MuscaVie extends Musca {

    private Boolean _proaspatMoarta;
    private IStrategie _strategie;

    public MuscaVie(Image x, Point z) {
        super(x, z);
        _pozaMusca = x;
        _pozitie = z;
        _orientare = new Orientare();
        _proaspatMoarta = false;
        _strategie = null;
    }

    public void aplicaStrategie(Dimension boundaries) {
        if (_strategie == null) {
            GeneratorStrategii x = new GeneratorStrategii();
            _strategie = x.genereazaStrategie(this, boundaries);
        }
        _strategie.aplicaStrategie();

    }

    public Boolean getProaspatMoarta() {
        return _proaspatMoarta;
    }

    public void setProaspatMoarta() {
        _proaspatMoarta = true;
    }
}
