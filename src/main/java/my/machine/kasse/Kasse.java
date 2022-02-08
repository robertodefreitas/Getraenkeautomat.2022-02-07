package my.machine.kasse;

public class Kasse {

    Muenzen vorhandeneMuenzen;


    /* constructor */

    public Kasse() {}

    public Kasse(Muenzen vorhandeneMuenzen) {
        this.vorhandeneMuenzen = vorhandeneMuenzen;
    }


    /* getters and setters */

    public Muenzen getVorhandeneMuenzen() {
        return vorhandeneMuenzen;
    }

    public void setVorhandeneMuenzen(Muenzen vorhandeneMuenzen) {
        this.vorhandeneMuenzen = vorhandeneMuenzen;
    }


    /* methods */

    public void muenzenHinzufuegen(Muenzen muenzen){
        this.vorhandeneMuenzen.c10Menge = this.vorhandeneMuenzen.c10Menge + muenzen.c10Menge;
        this.vorhandeneMuenzen.c20Menge = this.vorhandeneMuenzen.c20Menge + muenzen.c20Menge;
        this.vorhandeneMuenzen.c50Menge = this.vorhandeneMuenzen.c50Menge + muenzen.c50Menge;
        this.vorhandeneMuenzen.c100Menge = this.vorhandeneMuenzen.c100Menge + muenzen.c100Menge;
        this.vorhandeneMuenzen.c200Menge = this.vorhandeneMuenzen.c200Menge + muenzen.c200Menge;
    }

    public void muenzenAbziehen(Muenzen muenzen){
        this.vorhandeneMuenzen.c10Menge = this.vorhandeneMuenzen.c10Menge - muenzen.c10Menge;
        this.vorhandeneMuenzen.c20Menge = this.vorhandeneMuenzen.c20Menge - muenzen.c20Menge;
        this.vorhandeneMuenzen.c50Menge = this.vorhandeneMuenzen.c50Menge - muenzen.c50Menge;
        this.vorhandeneMuenzen.c100Menge = this.vorhandeneMuenzen.c100Menge - muenzen.c100Menge;
        this.vorhandeneMuenzen.c200Menge = this.vorhandeneMuenzen.c200Menge - muenzen.c200Menge;
    }

    public Double summeKasseBetrag(){
        String methodeName = new Object(){}.getClass().getEnclosingMethod().getName();
        Double summeBetrag = this.vorhandeneMuenzen.umwandelnMuenzen2GeldBetrag();
        System.out.println("WARN [" + methodeName + "] die Betragsumme der Kasse: " + summeBetrag);
        return summeBetrag;
    }
}
