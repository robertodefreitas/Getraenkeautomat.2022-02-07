package my.machine.kasse;

public class Muenzen {
    Integer c10Menge;
    Integer c20Menge;
    Integer c50Menge;
    Integer c100Menge;
    Integer c200Menge;


    /* constructor */

    public Muenzen() {}

    public Muenzen(Integer c10Menge, Integer c20Menge, Integer c50Menge, Integer c100Menge, Integer c200Menge) {
        this.c10Menge = c10Menge;
        this.c20Menge = c20Menge;
        this.c50Menge = c50Menge;
        this.c100Menge = c100Menge;
        this.c200Menge = c200Menge;
    }


    /* getters and setters */

    public Integer getC10Menge() {
        return c10Menge;
    }

    public void setC10Menge(Integer c10Menge) {
        this.c10Menge = c10Menge;
    }

    public Integer getC20Menge() {
        return c20Menge;
    }

    public void setC20Menge(Integer c20Menge) {
        this.c20Menge = c20Menge;
    }

    public Integer getC50Menge() {
        return c50Menge;
    }

    public void setC50Menge(Integer c50Menge) {
        this.c50Menge = c50Menge;
    }

    public Integer getC100Menge() {
        return c100Menge;
    }

    public void setC100Menge(Integer c100Menge) {
        this.c100Menge = c100Menge;
    }

    public Integer getC200Menge() {
        return c200Menge;
    }

    public void setC200Menge(Integer c200Menge) {
        this.c200Menge = c200Menge;
    }


    /* methods */

    public void setMuenze(Integer muenze, Integer anzahl){
        switch (muenze) {
            case 200:
                setC200Menge(anzahl);
                break;
            case 100:
                setC100Menge(anzahl);
                break;
            case 50:
                setC50Menge(anzahl);
                break;
            case 20:
                setC20Menge(anzahl);
                break;
            case 10:
                setC10Menge(anzahl);
                break;
        }
    }

    public Integer umwandelnGeldBetrag2Cents(Double geldBetrag){
        return (int) Math.round(geldBetrag * 100);
    }

    public Muenzen umwandelnGeldBetrag2Muenzen(Double geldBetrag){

        Integer cents = umwandelnGeldBetrag2Cents(geldBetrag);
        Muenzen muenzen = new Muenzen();

        // ORDER: first: 200 ... last: 1
        Integer[] muenzenArray = {200, 100, 50, 20, 10};

        for (Integer muenze: muenzenArray){
            /**
             * https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html
             * ## public static int floorDiv(int x, int y)
             * For example, floorDiv(4, 3) == 1 and (4 / 3) == 1.
             *
             * Returns the floor modulus of the int arguments.
             * ## public static int floorMod(int x, int y)
             * floorMod(5, 3) == 2;   and (5 % 3) == 2
             *     x - the dividend
             *     y - the divisor
             */
            Integer result = Math.floorDiv(cents,muenze);
            Integer resultMod = Math.floorMod(cents,muenze);

            if (result != 0){
                muenzen.setMuenze(muenze,result);
                cents = result;
            } else {
                muenzen.setMuenze(muenze,0);
            }
            if (resultMod != 0) {
                cents = resultMod;
            }
        }

        return muenzen;
    }

    public Double umwandelnCents2GeldBetrag(Integer geldBetragCents){
        return (geldBetragCents.doubleValue() / 100);
    }

    public Double umwandelnMuenzen2GeldBetrag() {
        Integer summeCents =
                this.c10Menge*10 +
                this.c20Menge*20 +
                this.c50Menge*50 +
                this.c100Menge*100 +
                this.c200Menge*200;

        return umwandelnCents2GeldBetrag(summeCents);
    }
}
