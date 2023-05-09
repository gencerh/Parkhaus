public class Fahrzeug {
    @Override
    public String toString() {
        return "Fahrzeug{" +
                "kennzeichen='" + kennzeichen + '\'' +
                ", etage=" + etage +
                ", platz=" + platz +
                '}';
    }

    private String kennzeichen;
    private String platzz;
    private boolean istInDerGarage;
    private int etage;
    private int platz;

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public int getPlatz() {
        return platz;
    }

    public void setPlatz(int platz) {
        this.platz = platz;
    }

    public Fahrzeug(String kennzeichen) {
        this.platzz=null;
        this.istInDerGarage=false;
        this.kennzeichen = kennzeichen;
    }

    public String getPlatzz() {
        return platzz;
    }

    public void setPlatzz(String platzz) {
        this.platzz = platzz;
    }

    public boolean isIstInDerGarage() {
        return istInDerGarage;
    }

    public void setIstInDerGarage(boolean istInDerGarage) {
        this.istInDerGarage = istInDerGarage;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }
}
