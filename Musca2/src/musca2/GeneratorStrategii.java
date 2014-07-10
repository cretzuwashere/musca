package musca2;

import java.awt.Dimension;

public class GeneratorStrategii {

    int x;
    IStrategie strategie;

    public void random() {
        x = (int) (Math.random() * 10) / 5;
    }

    public IStrategie genereazaStrategie(MuscaVie musca, Dimension limite) {
        random();
        switch (x) {
            case 0: {
                strategie = new Strategie1(musca, limite);
                return strategie;
            }
            case 1: {
                strategie = new Strategie2(musca, limite);
                return strategie;
            }
        }
        return null;
    }

    public int getx() {
        return x;
    }

}
