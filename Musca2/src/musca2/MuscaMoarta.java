package musca2;

import java.awt.Image;
import java.awt.Point;

public class MuscaMoarta extends Musca {

    private Integer _dataMortii;

    public MuscaMoarta(Image x, Point z) {
        super(x, z);
        _pozaMusca = x;
        _pozitie = z;
    }

    public void setDataMortii(Integer x) {
        _dataMortii = x;
    }

    public Integer getDataMortii() {
        return _dataMortii;
    }

}
