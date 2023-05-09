import java.util.ArrayList;
import java.util.HashMap;

public class Parkhaus {

    private ArrayList<Parketage> etagen;
    private ArrayList<Fahrzeug> fahrzeuge;


    public Parkhaus(ArrayList<Parketage> etagen) {
        this.etagen = etagen;
    }

    public Parkhaus() {
        this.etagen=new ArrayList<Parketage>();
        this.fahrzeuge=new ArrayList<Fahrzeug>();
    }

    public ArrayList<Parketage> getEtagen() {
        return etagen;
    }

    public void addFahrzeug(Fahrzeug fahrzeug){
        this.fahrzeuge.add(fahrzeug);
    }

    public void addEtage(int ppAnzahl){
        int etagenAnzahl=etagen.size();
        HashMap<Integer, Boolean> parkplaetze=new HashMap<Integer, Boolean>();
        for (int i = 0; i <ppAnzahl ; i++) {
            parkplaetze.put(i+1,false);
        }
        this.etagen.add(new Parketage(etagenAnzahl+1,parkplaetze));
    }
    public void removeEtage(){
        int etagenAnzahl=etagen.size();
        this.etagen.remove(etagenAnzahl-1);
    }
    public void park(Fahrzeug fahrzeug){
        if (fahrzeug.isIstInDerGarage()) {
            System.out.println("Fahrzeug ist schon in der Garage");
            return;
        }
        boolean pplatz=findPark(fahrzeug);
        if(pplatz==false){
            System.out.println("Kein frei Parkplatz");
            return;
        }
        fahrzeug.setIstInDerGarage(true);

    }
    private boolean findPark(Fahrzeug fahrzeug){
        for (int i = 0; i <this.etagen.size() ; i++) {
            for (int j = 1; j <=this.etagen.get(i).getParkplaetze().size() ; j++) {
                //System.out.println(etagen.get(i).getParkplaetze().get(j));
                if((etagen.get(i).getParkplaetze().get(j)==false)){
                    String ret=Integer.toString(i)+Integer.toString(j);
                    fahrzeug.setEtage(i);
                    fahrzeug.setPlatz(j);
                    etagen.get(i).getParkplaetze().replace(j,true);
                    System.out.println("Fahrzeugparkplatz Zuwesiung: "+i+".Etage -- "+j+".Parkplatz");
                    return true;
                }
            }

        }
        return false;
    }

    public void ausfahren(Fahrzeug fahrzeug){
        if (fahrzeug.isIstInDerGarage()) {
            System.out.println("Auto ist weg von der Garage");
            fahrzeug.setIstInDerGarage(false);
            this.etagen.get(fahrzeug.getEtage()).getParkplaetze().replace(fahrzeug.getPlatz(), false);
        }

    }

    public ArrayList<Fahrzeug> getFahrzeuge() {
        return fahrzeuge;
    }

}
