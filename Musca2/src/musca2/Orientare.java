package musca2;

public class Orientare {

    private Boolean _directieSus, _directieDreapta;

    public Orientare() {
        _directieSus = true;
        _directieDreapta = true;
    }

    public Boolean getDirectieSus() {
        return _directieSus;
    }

    public Boolean getDirectieDreapta() {
        return _directieDreapta;
    }

    public void setDirectieSus(Boolean x) {
        _directieSus = x;
    }

    public void setDirectieDreapta(Boolean x) {
        _directieDreapta = x;
    }
}
