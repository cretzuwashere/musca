package musca2;

import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import javax.imageio.*;

public class GeneratorMusteVii {
     
    private URL _urlVie;
    private Point _pozitie;
    
    public GeneratorMusteVii(URL x){
        _urlVie = x;
    }
    
    public MuscaVie genereazaMuscaVie(Point z) throws IOException{
        _pozitie = z;
        MuscaVie x=new MuscaVie(ImageIO.read(_urlVie),_pozitie);
        return x;
    }
        
}
