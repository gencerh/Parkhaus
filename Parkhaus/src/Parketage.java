import java.util.HashMap;

public class Parketage {
    private int id;
    private HashMap<Integer, Boolean> parkplaetze;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, Boolean> getParkplaetze() {
        return parkplaetze;
    }

    public void setParkplaetze(HashMap<Integer, Boolean> parkplaetze) {
        this.parkplaetze = parkplaetze;
    }

    public Parketage(int id, HashMap<Integer, Boolean> parkplaetze) {
        this.id = id;
        this.parkplaetze = parkplaetze;
    }

    public void addParkplaetze(int ppAnzahl){
        int ppsize = this.parkplaetze.size();
        for (int i = ppsize; i <=ppsize+ppAnzahl ; i++) {
            this.parkplaetze.put(i,false);
        }
    }
    public void removeParkplaetze(){
        int ppsize = this.parkplaetze.size();
        for (int i = ppsize; i >ppsize-10 ; i--) {
            this.parkplaetze.remove(i);
        }
    }

    @Override
    public String toString() {
        return "Parketage{"+this.id+" --- Parkplatze Anzahl:"+parkplaetze.size()+"}";
    }
}
