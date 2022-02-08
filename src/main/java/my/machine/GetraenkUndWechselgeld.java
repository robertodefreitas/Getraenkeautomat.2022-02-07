package my.machine;

public class GetraenkUndWechselgeld {

    private String getraenk;
    private Double wechselgeld;


    /* constructor */

    public GetraenkUndWechselgeld() {
    }

    public GetraenkUndWechselgeld(String getraenk, Double wechselgeld) {
        this.getraenk = getraenk;
        this.wechselgeld = wechselgeld;
    }

    /* getters and setters */

    public String getGetraenk() {
        return getraenk;
    }

    public void setGetraenk(String getraenk) {
        this.getraenk = getraenk;
    }

    public Double getWechselgeld() {
        return wechselgeld;
    }

    public void setWechselgeld(Double wechselgeld) {
        this.wechselgeld = wechselgeld;
    }

    /* methods */
}
