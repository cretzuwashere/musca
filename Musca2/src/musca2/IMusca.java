package musca2;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;

public interface IMusca {
    public Point getPozitie();
    public void setPozitie(Point x);
    public Image getPoza();
    public Orientare getOrientare();
    public void setOrientare(Orientare x);
    public abstract void aplicaStrategie(Dimension boundaries);
}
