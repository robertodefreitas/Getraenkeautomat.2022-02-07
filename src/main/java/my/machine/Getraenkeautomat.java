package my.machine;

import my.machine.kasse.Kasse;
import my.machine.kasse.Muenzen;
import my.machine.lager.Getraenkewunsch;

import java.util.List;

public class Getraenkeautomat {

    /**
     * List mit Getränkewunsch erstellen
     * weil mehrere Getränkesorten zum Auswahl geben soll
     */
    private List<Getraenkewunsch> getraenkewuensche;

    /**
     * Kasse für die gesammte Getraenkeautomat wird initialisiert
     */
    private Kasse kasse;


    /* constructor */

    public Getraenkeautomat(){}

    public Getraenkeautomat(List<Getraenkewunsch> getraenkewuensche, Kasse kasse) {
        this.kasse = kasse;
        this.getraenkewuensche = getraenkewuensche;
    }


    /* getters and setters */

    public List<Getraenkewunsch> getGetraenkewuensche() {
        return getraenkewuensche;
    }

    public void setGetraenkewuensche(List<Getraenkewunsch> getraenkewuensche) {
        this.getraenkewuensche = getraenkewuensche;
    }

    public Kasse getKasse() {
        return kasse;
    }

    public void setKasse(Kasse kasse) {
        this.kasse = kasse;
    }


    /* methods */

    public Getraenkewunsch getraenkSuchen(String auswahl){
//        for (Getraenkewunsch getraenkewunsch : getraenkewuensche){
//            if (getraenkewunsch.getGetraenkeName().equals(auswahl)){
//                return getraenkewunsch;
//            }
//        }
        Getraenkewunsch getraenkewunschGefunden = getraenkewuensche.stream()
                //.filter(Getraenkewunsch -> "apfelschorle".equals(Getraenkewunsch.getGetraenkeName()))
                .filter(Getraenkewunsch -> auswahl.equals(Getraenkewunsch.getGetraenkeName()))
                .findAny()
                .orElse(null);
        return getraenkewunschGefunden;
    }

    public Integer summeAllerGetraenkewunsch(){
        String methodeName = new Object(){}.getClass().getEnclosingMethod().getName();

        Integer summeGetraenkewunsch = getraenkewuensche.size();

        System.out.println("INFO [" + methodeName + "] Summe aller Getränke im Getränkeautomat: " + summeGetraenkewunsch);
        return summeGetraenkewunsch;
    }

    public Integer summeAllerGetraenke(){
        String methodeName = new Object(){}.getClass().getEnclosingMethod().getName();

        // https://www.baeldung.com/java-stream-sum
        Integer summe = getraenkewuensche.stream()
                .map(getraenkewunsch -> getraenkewunsch.getGetraenkeMenge())
                .reduce(0,Integer::sum);

        System.out.println("INFO [" + methodeName + "] Summe aller Getränke im Getränkeautomat: " + summe);
        return summe;
    }

    public GetraenkUndWechselgeld kaufen(Getraenkewunsch auswahl, Muenzen einzahlung){
        String methodeName = new Object(){}.getClass().getEnclosingMethod().getName();

        Double einzahlungBetrag = einzahlung.umwandelnMuenzen2GeldBetrag();

        if (auswahl.einzahlungAusreichend(einzahlungBetrag)){
            System.out.println("INFO [" + methodeName + "] Es ist genug geld vorhanden.");

            if (auswahl.istGetraenkeVorhanden()){
                System.out.println("INFO [" + methodeName + "] Es ist genug Getränke vorhanden.");

                auswahl.getraenkeKonsumieren();
                kasse.muenzenHinzufuegen(einzahlung);

                // wechselgeld wird berechnet
                Double wechselGeldBetrag = einzahlungBetrag - auswahl.getGetraenkePreis();

                Muenzen wechselGeldMuenzen = new Muenzen();
                wechselGeldMuenzen = wechselGeldMuenzen.umwandelnGeldBetrag2Muenzen(wechselGeldBetrag);
                kasse.muenzenAbziehen(wechselGeldMuenzen);

                System.out.println("INFO [" + methodeName + "] Wechselgeld: " + wechselGeldMuenzen.umwandelnMuenzen2GeldBetrag());
                System.out.println("INFO [" + methodeName + "] Der Einkauf ist erfolgreich abgeschlossen.");

                GetraenkUndWechselgeld getraenkUndWechselgeld =
                        new GetraenkUndWechselgeld(
                                auswahl.getGetraenkeName(),
                                wechselGeldMuenzen.umwandelnMuenzen2GeldBetrag()
                        );
                return getraenkUndWechselgeld;

            } else {
                System.out.println("WARN [" + methodeName + "] Es ist nicht genug Getränke vorhaden.");
                System.out.println("WARN [" + methodeName + "] Einkauf ist abgebrochen");

                GetraenkUndWechselgeld getraenkUndWechselgeld =
                        new GetraenkUndWechselgeld(
                                "KEIN_GETRAENK",
                                einzahlungBetrag
                        );
                return getraenkUndWechselgeld;
            }

        } else {
            System.out.println("WARN [" + methodeName + "] Der Geldbetrag ist nicht ausreichend.");
            System.out.println("WARN [" + methodeName + "] Einkauf ist abgebrochen");

            GetraenkUndWechselgeld getraenkUndWechselgeld =
                    new GetraenkUndWechselgeld(
                            "KEIN_GETRAENK",
                            einzahlungBetrag
                    );
            return getraenkUndWechselgeld;
        }
    }


}