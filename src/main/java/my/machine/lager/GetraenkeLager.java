package my.machine.lager;

class GetraenkeLager {
    public Integer mengeSumme;
    public Integer mengeFaecher;

    /* constructor */

    public GetraenkeLager() {
        this.mengeSumme = 0;
        this.mengeFaecher = 0;
    }

    public GetraenkeLager(Integer mengeSumme, Integer mengeFaecher) {
        this.mengeSumme = mengeSumme;
        this.mengeFaecher = mengeFaecher;
    }

    /* getters and setters */

    public Integer getMengeSumme() {
        return mengeSumme;
    }

    public void setMengeSumme(Integer mengeSumme) {
        this.mengeSumme = mengeSumme;
    }

    public Integer getMengeFaecher() {
        return mengeFaecher;
    }

    public void setMengeFaecher(Integer mengeFaecher) {
        this.mengeFaecher = mengeFaecher;
    }

    /* methods */

}
