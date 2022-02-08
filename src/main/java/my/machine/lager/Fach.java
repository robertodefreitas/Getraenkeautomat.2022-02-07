package my.machine.lager;

public class Fach extends GetraenkeLager {

    Integer id;
    Integer menge;
    Double preis;


    /* constructor */

    public Fach() {}

    public Fach(Integer id, Integer menge, Double preis) {
        this.id = id;
        this.menge = menge;
        this.preis = preis;

        setMengeSumme(getMengeSumme() + this.menge);
        setMengeFaecher(getMengeFaecher() +1 );
    }


    /* getters and setters */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenge() {
        return menge;
    }

    public void setMenge(Integer menge) {
        this.menge = menge;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    /* methods */

    public boolean istGetraenkeVorhanden(){
        if (this.menge > 0){
            return true;
        }
        return false;
    }

    public void getraenkeKonsumieren(){
        this.menge = this.menge - 1;
    }

    public boolean einzahlungAusreichend(Double einzahlung){
        if (einzahlung > this.preis){
            return true;
        }
        return false;
    }
}
