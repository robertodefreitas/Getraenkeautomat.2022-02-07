
import my.machine.GetraenkUndWechselgeld;
import my.machine.Getraenkeautomat;
import my.machine.kasse.Kasse;
import my.machine.kasse.Muenzen;
import my.machine.lager.Getraenkewunsch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetraenkeautomatUnitTest {

    private Getraenkeautomat getraenkeautomat =
            new Getraenkeautomat(
                    getraenkewuenscheErstellen(),
                    kasseErstellen());

    /* TESTS */

    @Test
    public void getraenkewunschTest(){
        Muenzen einzahlung = muenzenErstellen();
        String getraenk = "apfelschorle";
        Getraenkewunsch auswahl = getraenkeautomat.getraenkSuchen(getraenk);

        Integer getraenkeMengeVorKaufen = auswahl.getGetraenkeMenge();
        GetraenkUndWechselgeld getraenkUndWechselgeld = getraenkeautomat.kaufen(auswahl, einzahlung);
        Integer getraenkeMengeNachKaufen = auswahl.getGetraenkeMenge();

        Assertions.assertNotEquals(getraenkeMengeVorKaufen, getraenkeMengeNachKaufen);
        Assertions.assertEquals(getraenk, getraenkUndWechselgeld.getGetraenk());
    }

    @Test
    public void getraenkewunschAnzahlTest(){
        Integer summeAllerGetraenke = getraenkeautomat.summeAllerGetraenke();
        Integer summeAllerGetraenkewunsch = getraenkeautomat.summeAllerGetraenkewunsch();

        Assertions.assertEquals(20, summeAllerGetraenke);
        Assertions.assertEquals(4, summeAllerGetraenkewunsch);
    }


    /* METHODS */

    private Muenzen muenzenErstellen() {
        return new Muenzen(1,2,1,1,0);
    }

    private Kasse kasseErstellen() {
        Muenzen muenzenStartKasse = new Muenzen(10,10,10,10,10);
        return new Kasse(muenzenStartKasse);
    }

    private List<Getraenkewunsch> getraenkewuenscheErstellen(){
        List<Getraenkewunsch> getraenkewuensche = new ArrayList<>();

        getraenkewuensche.add(new Getraenkewunsch(1,"wasser",5,1.0));
        getraenkewuensche.add(new Getraenkewunsch(2,"apfelschorle",5,1.234));
        getraenkewuensche.add(new Getraenkewunsch(3,"cola",5,1.99));
        getraenkewuensche.add(new Getraenkewunsch(4,"wasser",5,1.1));

        return getraenkewuensche;
    }


/*

    private Integer fachId = 0;

    @Test
    public void fachErstellungTest(){
        Getraenkewunsch wasser = fachErstellen(5,1.234);
        Getraenkewunsch cola = fachErstellen(4,1.99);

        Assertions.assertEquals(1, wasser.getGetraenkeId());
        Assertions.assertEquals(2, cola.getGetraenkeId());
        Assertions.assertTrue(wasser.getMengeFaecher() == 1);
        Assertions.assertTrue(cola.getMengeFaecher() == 1);
    }

    @Test
    public void einkaufenGeldAusreichendTest(){
        //Kasse kasse = kasseErstellen();
        Getraenkewunsch wasser = fachErstellen(5,1.234);
        Muenzen einzahlungMuenzen = muenzenErstellen();

        Double kasseBetragVorEinkaufen = kasse.summeKasseBetrag();
        Einkaufen(wasser, einzahlungMuenzen, kasse);
        Double kasseBetragNachEinkaufen = kasse.summeKasseBetrag();

        Assertions.assertNotEquals(kasseBetragVorEinkaufen, kasseBetragNachEinkaufen);
    }

    @Test
    public void einkaufenGeldNichtAusreichendTest(){
        Getraenkewunsch cola = fachErstellen(4,2.01);
        Muenzen einzahlungMuenzen = muenzenErstellen();

        Double kasseBetragVorEinkaufen = kasse.summeKasseBetrag();
        Einkaufen(cola, einzahlungMuenzen, kasse);
        Double kasseBetragNachEinkaufen = kasse.summeKasseBetrag();

        Assertions.assertEquals(kasseBetragVorEinkaufen, kasseBetragNachEinkaufen);
    }

    @Test
    public void fachMengeTest(){
        //Kasse kasse = kasseErstellen();
        Getraenkewunsch wasser = fachErstellen(5,1.234);
        Muenzen einzahlungMuenzen = muenzenErstellen();

        Integer mengeVorEinkaufen = wasser.getGetraenkeMenge();
        Einkaufen(wasser, einzahlungMuenzen, kasse);
        Integer mengeNachEinkaufen = wasser.getGetraenkeMenge();

        Assertions.assertNotEquals(mengeVorEinkaufen,mengeNachEinkaufen);
        Assertions.assertTrue(wasser.getGetraenkeMenge() == 4);
    }

    /* METHODS * /

    private Getraenkewunsch fachErstellen(Integer menge, Double preis) {
        this.fachId = this.fachId + 1;
        return new Getraenkewunsch(this.fachId,menge,preis);
    }

*/
}
