package musca2;

import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class GeneratorMusteMoarte {

    private URL _urlMoarta;
    private Point _pozitie;

    public GeneratorMusteMoarte(URL x) {
        _urlMoarta = x;
    }

    public MuscaMoarta genereazaMuscaMoarta(Point z) throws IOException {
        _pozitie = z;
        MuscaMoarta x = new MuscaMoarta(ImageIO.read(_urlMoarta), _pozitie);
        return x;
    }
}
