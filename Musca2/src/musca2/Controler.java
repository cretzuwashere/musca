package musca2;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Controler implements Runnable {

    IViewMuste _view;
    private ArrayList<MuscaVie> listaMusteVii;
    private ArrayList<MuscaMoarta> listaMusteMoarte;
    private ArrayList<Musca> listaMusteDescompuse;
    private ArrayList<IMusca> _listaMusteDeDesenat;
    private GeneratorMusteVii generatorMusteVii;
    private GeneratorMusteMoarte generatorMusteMoarte;
    private ProcesatorClick _detaliiClick;
    private MouseEvent _click;

    public Controler(IViewMuste view, URL codebase) {
        _view = view;
        try {
            generatorMusteVii = new GeneratorMusteVii(new URL(codebase , "musca.png"));
            generatorMusteMoarte = new GeneratorMusteMoarte(new URL(codebase , "muscamoarta.png"));
            initializeazaMusteVii();
            initializeazaMusteMoarte();
            _click = null;
        } catch (IOException ex) {
        }
    }

    private void initializeazaMusteVii() throws MalformedURLException, IOException {
        listaMusteVii = new ArrayList<MuscaVie>();
        listaMusteVii.add(generatorMusteVii.genereazaMuscaVie(new Point(0, 0)));
        _listaMusteDeDesenat = new ArrayList<>();
    }

    private void initializeazaMusteMoarte() {
        listaMusteMoarte = new ArrayList<MuscaMoarta>();
        listaMusteDescompuse = new ArrayList<Musca>();
    }

    @Override
    public void run() {
        do {
            try {
                _listaMusteDeDesenat.clear();
                _click = _view.getLastClick();
                if (_click != null) {
                    System.out.println(_click.getButton());
                    _view.cleanLastClick();
                    _detaliiClick = new ProcesatorClick(_click, listaMusteVii, generatorMusteVii, listaMusteMoarte, generatorMusteMoarte);
                }
                for (MuscaVie musca : listaMusteVii) {
                    musca.aplicaStrategie(_view.getSize());
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
                if (listaMusteVii != null || listaMusteMoarte != null) {
                    for (MuscaVie musca : listaMusteVii) {
                        _listaMusteDeDesenat.add(musca);
                    }
                    for (MuscaMoarta musca : listaMusteMoarte) {
                        _listaMusteDeDesenat.add(musca);
                    }
                    _view.setListaMuste(_listaMusteDeDesenat);
                    _view.repaint();
                }
            } catch (IOException ex) {
            }
        } while (true);
    }
}
