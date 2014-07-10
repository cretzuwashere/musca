package musca2;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Musca2 extends Applet implements Runnable, MouseListener {

    Image muscaVie, muscaMoarta, offScreen;
    Thread firdeexecutie;
    ArrayList<MuscaVie> listaMusteVii;
    ArrayList<MuscaMoarta> listaMusteMoarte;
    ArrayList<Musca> listaMusteDescompuse;
    GeneratorMusteVii generatorMusteVii;
    GeneratorMusteMoarte generatorMusteMoarte;
    Image imagineBuffer;
    Graphics graphicsBuffer;
    Click _detaliiClick;

    @Override
    public void init() {
        firdeexecutie = new Thread(this);
        this.addMouseListener(this);
        try {
            generatorMusteVii = new GeneratorMusteVii(new URL(getCodeBase(), "musca.png"));
            generatorMusteMoarte = new GeneratorMusteMoarte(new URL(getCodeBase(), "muscamoarta.png"));
            System.out.println(getCodeBase());
            generatorMusteVii();
            generatorMusteMoarte();
        } catch (IOException ex) {
        }
        firdeexecutie.start();
    }

    @Override
    public void paint(Graphics g) {
        imagineBuffer = createImage(getWidth(), getHeight());
        graphicsBuffer = imagineBuffer.getGraphics();
        imgBuff(graphicsBuffer);
        g.drawImage(imagineBuffer, 0, 0, this);
    }

    public void imgBuff(Graphics g) {
        if (listaMusteVii != null) {
            for (MuscaVie musca : listaMusteVii) {
                g.drawImage(musca.getPoza(), musca.getPozitie().x, musca.getPozitie().y, 50, 50, null);
            }
        }
        if (listaMusteMoarte != null) {
            for (MuscaMoarta musca : listaMusteMoarte) {
                g.drawImage(musca.getPoza(), musca.getPozitie().x, musca.getPozitie().y, 50, 50, null);
            }
        }
    }

    @Override
    public void run() {
        do {
            try {
                for (MuscaVie musca : listaMusteVii) {
                    musca.aplicaStrategie(this.getSize());
                }
                if (_detaliiClick != null) {
                    _detaliiClick.evenimentClick();
                    _detaliiClick = null;
                }
                if (listaMusteMoarte != null) {
                    for (MuscaMoarta musca : listaMusteMoarte) {
                        musca.setDataMortii(musca.getDataMortii() + 1);
                        if (musca.getDataMortii() == 20) {
                            listaMusteDescompuse.add(musca);
                        }
                    }
                }
                if (listaMusteDescompuse != null) {
                    for (Musca musca : listaMusteDescompuse) {
                        listaMusteMoarte.remove(musca);
                    }
                }
                repaint();
                firdeexecutie.sleep(40);
            } catch (InterruptedException ex) {
            } catch (IOException ex) {
            }
        } while (true);
    }

    private void generatorMusteVii() throws MalformedURLException, IOException {
        listaMusteVii = new ArrayList<MuscaVie>();
        listaMusteVii.add(generatorMusteVii.genereazaMuscaVie(new Point(0, 0)));
    }

    private void generatorMusteMoarte() {
        listaMusteMoarte = new ArrayList<MuscaMoarta>();
        listaMusteDescompuse = new ArrayList<Musca>();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        _detaliiClick = new Click(me, listaMusteVii, generatorMusteVii, listaMusteMoarte, generatorMusteMoarte);
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
