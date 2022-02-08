
import my.machine.kasse.Kasse;
import my.machine.kasse.Muenzen;
import my.machine.lager.Fach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static my.machine.Getraenkeautomat.Einkaufen;

public class GetraenkeautomatUnitTest {

    private Integer fachId = 0; // started
    private Kasse kasse = kasseErstellen();

    @Test
    public void fachErstellungTest(){
        Fach wasser = fachErstellen(5,1.234);
        Fach cola = fachErstellen(4,1.99);

        Assertions.assertEquals(1, wasser.getId());
        Assertions.assertEquals(2, cola.getId());
        Assertions.assertTrue(wasser.getMengeFaecher() == 1);
        Assertions.assertTrue(cola.getMengeFaecher() == 1);
    }

    @Test
    public void einkaufenGeldAusreichendTest(){
        //Kasse kasse = kasseErstellen();
        Fach wasser = fachErstellen(5,1.234);
        Muenzen einzahlungMuenzen = muenzenErstellen();

        Double kasseBetragVorEinkaufen = this.kasse.summeKasseBetrag();
        Einkaufen(wasser, einzahlungMuenzen, this.kasse);
        Double kasseBetragNachEinkaufen = this.kasse.summeKasseBetrag();

        Assertions.assertNotEquals(kasseBetragVorEinkaufen, kasseBetragNachEinkaufen);
    }

    @Test
    public void einkaufenGeldNichtAusreichendTest(){
        Fach cola = fachErstellen(4,1.99);
        Muenzen einzahlungMuenzen = muenzenErstellen();

        Double kasseBetragVorEinkaufen = this.kasse.summeKasseBetrag();
        Einkaufen(cola, einzahlungMuenzen, this.kasse);
        Double kasseBetragNachEinkaufen = this.kasse.summeKasseBetrag();

        Assertions.assertEquals(kasseBetragVorEinkaufen, kasseBetragNachEinkaufen);
    }

    private static Kasse kasseErstellen() {
        Muenzen muenzenStartKasse = new Muenzen(10,10,10,10,10);
        return new Kasse(muenzenStartKasse);
    }

    private Fach fachErstellen(Integer menge, Double preis) {
        this.fachId = this.fachId + 1;
        return new Fach(this.fachId,menge,preis);
    }

    private Muenzen muenzenErstellen() {
        return new Muenzen(0,0,1,1,0);
    }

}
