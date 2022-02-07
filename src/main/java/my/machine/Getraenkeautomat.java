package my.machine;

public class Getraenkeautomat {

    public static void main(String[] args) {
        String methodeName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println("INFO [" + methodeName + "] Getränkeautomat ist gestartet...");

//        Muenzen muenzenStartKasse = new Muenzen(10,10,10,10,10);
//        Kasse kasse = new Kasse(muenzenStartKasse);
//        Fach wasser = new Fach(1,5,1.234);
//        Fach cola = new Fach(2,5,2.1);
//
//        Muenzen einzahlungMuenzen = new Muenzen(0,0,0,0,1);
//        Einkaufen(cola, einzahlungMuenzen, kasse);
//        Einkaufen(wasser, einzahlungMuenzen, kasse);
//        System.out.println("INFO [" + methodeName + "] Getränkeautomat ist fertig.");
    }

    public static void Einkaufen(Fach fach, Muenzen einzahlungMuenzen, Kasse kasse){
        String methodeName = new Object(){}.getClass().getEnclosingMethod().getName();

        Double einzahlungBetrag = einzahlungMuenzen.umwandelnMuenzen2GeldBetrag();

        if (fach.einzahlungAusreichend(einzahlungBetrag)){
            System.out.println("INFO [" + methodeName + "] Es ist genug geld vorhanden.");

            if (fach.istGetraenkeVorhanden()){
                System.out.println("INFO [" + methodeName + "] Es ist genug Getränke vorhanden.");

                fach.getraenkeKonsumieren();
                kasse.muenzenHinzufuegen(einzahlungMuenzen);

                // wechselgeld wird berechnet
                Double wechselGeldBetrag = einzahlungBetrag - fach.getPreis();

                Muenzen wechselGeldMuenzen = new Muenzen();
                wechselGeldMuenzen = wechselGeldMuenzen.umwandelnGeldBetrag2Muenzen(wechselGeldBetrag);
                kasse.muenzenAbziehen(wechselGeldMuenzen);

                System.out.println("INFO [" + methodeName + "] Wechselgeld: " + wechselGeldBetrag);

                System.out.println("INFO [" + methodeName + "] Der Einkauf ist erfolgreich abgeschlossen.");

            } else {
                System.out.println("WARN [" + methodeName + "] Es ist nicht genug Getränke vorhaden.");
                System.out.println("WARN [" + methodeName + "] Einkauf ist abgebrochen");
            }

        } else {
            System.out.println("WARN [" + methodeName + "] Der Geldbetrag ist nicht ausreichend.");
            System.out.println("WARN [" + methodeName + "] Einkauf ist abgebrochen");
        }
    }
}