package my.machine.lager;

public class Getraenkewunsch {

    Integer getraenkeId;
    String getraenkeName;
    Integer getraenkeMenge;
    Double getraenkePreis;


    /* constructor */

    public Getraenkewunsch() {}

    public Getraenkewunsch(Integer getraenkeId, String getraenkeName, Integer getraenkeMenge, Double getraenkePreis) {
        this.getraenkeId = getraenkeId;
        this.getraenkeName = getraenkeName;
        this.getraenkeMenge = getraenkeMenge;
        this.getraenkePreis = getraenkePreis;
    }


    /* getters and setters */

    public Integer getGetraenkeId() {
        return getraenkeId;
    }

    public void setGetraenkeId(Integer getraenkeId) {
        this.getraenkeId = getraenkeId;
    }

    public String getGetraenkeName() {
        return getraenkeName;
    }

    public void setGetraenkeName(String getraenkeName) {
        this.getraenkeName = getraenkeName;
    }

    public Integer getGetraenkeMenge() {
        return getraenkeMenge;
    }

    public void setGetraenkeMenge(Integer getraenkeMenge) {
        this.getraenkeMenge = getraenkeMenge;
    }

    public Double getGetraenkePreis() {
        return getraenkePreis;
    }

    public void setGetraenkePreis(Double getraenkePreis) {
        this.getraenkePreis = getraenkePreis;
    }


    /* methods */

    public boolean istGetraenkeVorhanden(){
        if (this.getraenkeMenge > 0){
            return true;
        }
        return false;
    }

    public void getraenkeKonsumieren(){
        this.getraenkeMenge = this.getraenkeMenge - 1;
    }

    public boolean einzahlungAusreichend(Double einzahlung){
        if (einzahlung > this.getraenkePreis){
            return true;
        }
        return false;
    }
}
