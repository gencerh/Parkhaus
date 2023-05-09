import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Parkhaus veniceParkhaus = new Parkhaus();
        veniceParkhaus.addEtage(5);
        veniceParkhaus.addEtage(5);

        System.out.println("--Zuerst wurden 2 Etagen und 5 Parkplätze auf jeder Etage gebaut--");

        Auto newAuto1 = new Auto("D MR 34");
        veniceParkhaus.addFahrzeug(newAuto1);
        veniceParkhaus.park(newAuto1);

        Auto newAuto2 = new Auto("D MR 33");
        veniceParkhaus.addFahrzeug(newAuto2);
        veniceParkhaus.park(newAuto2);

        Motorrad newMotorrad1 = new Motorrad("D MR 32");
        veniceParkhaus.addFahrzeug(newMotorrad1);
        veniceParkhaus.park(newMotorrad1);

        Motorrad newMotorrad2 = new Motorrad ("D MR 31");
        veniceParkhaus.addFahrzeug(newMotorrad2);
        veniceParkhaus.park(newMotorrad2);

        System.out.println("--2 Autos und 2 Motorraden wurden in die Garage hinzugefügt--");



        boolean loop = true;
        Scanner sc = new Scanner(System.in);

        while (loop) {
            System.out.println("Anweisungen\n1- Einfahren\n2- Ausfahren\n3- Parkplatz des Autos abfragen\n4- Anfragen zu leeren Parkplätzen\n5- Add Etage\n6- Etage löschen\n7- Exit");
            int input = sc.nextInt();
            sc.nextLine();
            switch (input) {
                case 1:
                    System.out.println("1- Auto\n2- Motorrad");
                    int type = sc.nextInt();
                    sc.nextLine();

                    if(type==1){
                        System.out.println("Geben Sie das Kennzeichen des einfahrenden Fahrzeugs ein.");
                        boolean istInderGarage=false;
                        String einfahrenkennzeichnen = sc.nextLine();
                        for (Fahrzeug fahrzeug : veniceParkhaus.getFahrzeuge()) {
                            if (fahrzeug.getKennzeichen().equals(einfahrenkennzeichnen)) {
                                veniceParkhaus.park(fahrzeug);
                                istInderGarage=true;
                                break;
                            }
                        }
                        if(!istInderGarage){
                            Auto newAuto = new Auto(einfahrenkennzeichnen);
                            veniceParkhaus.addFahrzeug(newAuto);
                            veniceParkhaus.park(newAuto);
                        }

                    }
                    else if(type==2){
                        System.out.println("Geben Sie das Kennzeichen des einfahrenden Fahrzeugs ein.");
                        boolean istInderGarage=false;
                        String einfahrenkennzeichnen = sc.nextLine();
                        for (Fahrzeug fahrzeug : veniceParkhaus.getFahrzeuge()) {
                            if (fahrzeug.getKennzeichen().equals(einfahrenkennzeichnen)) {
                                veniceParkhaus.park(fahrzeug);
                                istInderGarage=true;
                                break;
                            }
                        }
                        if(!istInderGarage){
                            Motorrad newMotorrad = new Motorrad(einfahrenkennzeichnen);
                            veniceParkhaus.addFahrzeug(newMotorrad);
                            veniceParkhaus.park(newMotorrad);
                        }

                    }

                    break;
                case 2:
                    System.out.println("Geben Sie das Kennzeichen des ausfahrenden Fahrzeugs ein.");
                    String ausfahrenkennzeichnen = sc.nextLine();
                    for (Fahrzeug fahrzeug : veniceParkhaus.getFahrzeuge()) {
                        if (fahrzeug.getKennzeichen().equals(ausfahrenkennzeichnen) && fahrzeug.isIstInDerGarage() == true) {
                            veniceParkhaus.ausfahren(fahrzeug);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Fahrzeugstandortabfrage, Kfz-Kennzeichen eingeben");
                    String abfragekennzeichnen = sc.nextLine();
                    boolean fahrzeugDa = false;
                    for (Fahrzeug fahrzeug : veniceParkhaus.getFahrzeuge()) {
                        if (fahrzeug.getKennzeichen().equals(abfragekennzeichnen) && fahrzeug.isIstInDerGarage() == true) {
                            fahrzeugDa = true;
                            System.out.println(fahrzeug);
                        }
                    }
                    if (!fahrzeugDa){
                    System.out.println("Auf dem Parkplatz befindet sich kein Fahrzeug mit diesem Kennzeichen.");
                    }
                    break;
                case 4:
                    int freiePlatz=0;
                    for (Parketage parketage : veniceParkhaus.getEtagen()) {
                        for (int i = 1; i <=parketage.getParkplaetze().size(); i++) {
                            if(parketage.getParkplaetze().get(i)==false){
                                freiePlatz++;
                            }
                        }
                    }
                    System.out.println("Die Anzahl der freien Parkplätze:"+freiePlatz+"\n");
                    break;
                case 5:
                    System.out.println("Geben Sie die Anzahl der Parkplaetze ein");
                    int ppAnzahl = sc.nextInt();
                    veniceParkhaus.addEtage(ppAnzahl);
                    System.out.println("1 Etage und "+ ppAnzahl +" Parkplätze zum Gebäude hinzugefügt");
                    break;

                case 6:
                    veniceParkhaus.removeEtage();
                    System.out.println("Die letzte Etage des Parks wurde gelöscht");
                    break;

                case 7:
                    loop = false;
                    break;
                default:
                    System.out.println("Geben Sie die Zahl zwischen 1 und 7 ein");

            }

        }

    }
}
