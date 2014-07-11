package musca2;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class ProcesatorClick {

    private MouseEvent _me;
    private ArrayList<MuscaVie> _liStaMusteVii;
    private ArrayList<MuscaVie> _musteProaspatMoarte;
    private ArrayList<MuscaMoarta> _listaMusteMoarte;
    private GeneratorMusteVii _generatorMusteVii;
    private GeneratorMusteMoarte _generatorMusteMoarte;
    private Boolean _ratat = true;

    public ProcesatorClick(MouseEvent me, ArrayList<MuscaVie> liStaMuste, GeneratorMusteVii generator, ArrayList<MuscaMoarta> listaMusteMoarte, GeneratorMusteMoarte generatorMusteMoarte) {
        _me = me;
        _liStaMusteVii = liStaMuste;
        _generatorMusteVii = generator;
        _listaMusteMoarte = listaMusteMoarte;
        _musteProaspatMoarte = new ArrayList<>();
        _generatorMusteMoarte = generatorMusteMoarte;
    }

    public void evenimentClick() throws IOException {
        _ratat = true;
        if (_me != null) {
            if (_me.getButton() == 1) {
                for (MuscaVie musca : _liStaMusteVii) {
                    if (_me.getX() >= musca.getPozitie().x && _me.getX() <= musca.getPozitie().x + 50) {
                        if (_me.getY() >= musca.getPozitie().y && _me.getY() <= musca.getPozitie().y + 50) {
                            musca.setProaspatMoarta();
                            _ratat = false;
                        }
                    }
                }
                if (_ratat) {
                    System.out.println("Ai ratat!");
                } else {
                    System.out.println("Ai nimerit!");
                }
            }
            if (_me.getButton() == 3) {
                try {
                    _liStaMusteVii.add(_generatorMusteVii.genereazaMuscaVie(_me.getPoint()));
                } catch (IOException ex) {
                }
                System.out.println(_liStaMusteVii.size());
            }
            transformaMuste();
        }
    }

    private void transformaMuste() throws IOException {
        if (_liStaMusteVii != null) {
            for (MuscaVie musca : _liStaMusteVii) {
                if (musca.getProaspatMoarta() == true) {
                    _musteProaspatMoarte.add(musca);
                    _listaMusteMoarte.add(_generatorMusteMoarte.genereazaMuscaMoarta(musca.getPozitie()));
                    _listaMusteMoarte.get(_listaMusteMoarte.size() - 1).setDataMortii(0);
                }
            }
            if (_musteProaspatMoarte != null) {
                for (MuscaVie musca : _musteProaspatMoarte) {
                    _liStaMusteVii.remove(musca);
                }
            }
        }

    }
}
