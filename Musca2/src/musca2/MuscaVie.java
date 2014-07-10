package musca2;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

public class MuscaVie extends Musca {
    
    private Image _pozaMusca;
    private Point _pozitie;
    public Orientare _orientare;
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
    
    public Orientare getOrientare() {
        return _orientare;
    }
    
    public void setOrientare(Orientare x) {
        _orientare = x;
    }
    
    public void setPozitie(Point x) {
        _pozitie = x;
    }
    
    public Point getPozitie() {
        return _pozitie;
    }
    
    public void aplicaStrategie(Dimension boundaries) {
        if (_strategie == null) {
            GeneratorStrategii x = new GeneratorStrategii();
            _strategie = x.genereazaStrategie(this, boundaries);
        } 
            _strategie.aplicaStrategie();
        
    }
    
    public Image getPoza() {
        return _pozaMusca;
    }
    
    public Boolean getProaspatMoarta() {
        return _proaspatMoarta;
    }
    
    public void setProaspatMoarta() {
        _proaspatMoarta = true;
    }
    
}
