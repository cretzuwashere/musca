package musca2;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Musca2 extends Applet implements MouseListener ,IViewMuste{

    Image imagineBuffer;
    Graphics graphicsBuffer;
    ArrayList<IMusca> _musteDeDesenat;
    MouseEvent _click;

    public Musca2() {
        _musteDeDesenat = new ArrayList<>();
    }

    @Override
    public void init() {
        this.addMouseListener(this);
        new Thread(new Controler(this,getCodeBase())).start();
    }

    @Override
    public void paint(Graphics g) {
        imagineBuffer = createImage(getWidth(), getHeight());
        graphicsBuffer = imagineBuffer.getGraphics();
        imgBuff(graphicsBuffer);
        g.drawImage(imagineBuffer, 0, 0, this);
    }

    public void imgBuff(Graphics g) {
        for (IMusca musca : _musteDeDesenat) {
            g.drawImage(musca.getPoza(), musca.getPozitie().x, musca.getPozitie().y, 50, 50, null);
        }
    }

    public void setListaMuste(ArrayList<IMusca> musteDeDesenat) {
        _musteDeDesenat = musteDeDesenat;
    }

    public ArrayList<IMusca> getListaMuste() {
        return _musteDeDesenat;
    }

    public MouseEvent getLastClick() {
        return _click;
    }

    public void cleanLastClick() {
        _click = null;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        _click = me;
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
