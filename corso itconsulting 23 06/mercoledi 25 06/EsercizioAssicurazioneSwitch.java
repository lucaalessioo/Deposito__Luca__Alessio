import java.util.Scanner;

public class EsercizioAssicurazioneSwitch {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        double prezzoBase = 200;

        int eta;
        int anniEsperienza=0;
        int incidenti;
        String pacchetto=null;

        // controllo idoneo
        boolean isIdoneo = true;

        // Controllo età
        System.out.println("Inserisci l'èta del conducente");
        eta = scanner.nextInt();

                // Se non maggiorenne imposto non idoneo
                if (eta < 18) {
                    System.out.println("Non sei idoneo per l'assicurazione.");
                    isIdoneo = false;
                }
                
        
        // se idoneo chiedo gli anni di esperienza e gli incidenti avuti negli ultimi 5 anni
        if (isIdoneo) {
            // Inserimento anni di esperienza
            System.out.println("Inserisci gli anni di esperienza alla guida:");
            anniEsperienza = scanner.nextInt();

            // Inserimento incidenti
            System.out.println("Inserisci il numero di incidenti negli ultimi 5 anni:");
            incidenti = scanner.nextInt();

            // Controllo il numero di incidenti con uno switch
            switch (incidenti) {
                case 0,1,2,3,4: System.out.println("Idoneo");     // In questi casi rimane idoneo
                default:
                    // Nel caso di default imposto non idoneo perche supera i 4 incidenti
                    if (incidenti > 4) {
                        System.out.println("Non sei idoneo per l'assicurazione.");
                        isIdoneo = false;
                    }
                    break;
            }
    }
                // Se continua ad essere idoneo chiedo il pacchetto
                  if (isIdoneo) {
                System.out.println("Scegli il pacchetto assicurativo (Base, Intermedio, Avanzato):");
                pacchetto = scanner.next();
                double maggiorazionePacchetto = 0.0;

                // Controllo il tipo di pacchetto scelto e applico la relativa maggiorazione
                switch (pacchetto.toLowerCase()) {
                    case "base":
                        maggiorazionePacchetto = 0.0;
                        break;
                    case "intermedio":
                        maggiorazionePacchetto = 0.20;
                        break;
                    case "avanzato":
                        maggiorazionePacchetto = 0.50;
                        break;
                    default:
                        System.out.println("Pacchetto non valido.");
                        isIdoneo = false;
                        break;
                }

                 if (isIdoneo) {
                    // Gestisco le maggiorazioni in base all'età 
                    double maggiorazioneEta = 0.0;
                    if (eta >= 18 && eta <= 25) { // Età compresa tra 18 e 25 anni
                        maggiorazioneEta = 0.20;
                    } else if (eta > 50) { // Età maggiore di 50 anni
                        maggiorazioneEta = -0.10;
                    }

                    // Gestisco la maggiorazione in base agli anni di esperienza
                    double maggiorazioneEsperienza = 0.0;
                    if (anniEsperienza < 2) { // Esperienza minore a 2 anni
                        maggiorazioneEsperienza = 0.30;
                    }

                    // Calcolo il prezzo finale
                    double prezzoFinale = prezzoBase;
                    prezzoFinale += prezzoBase * maggiorazioneEta;
                    prezzoFinale += prezzoBase * maggiorazioneEsperienza;
                    prezzoFinale += prezzoBase * maggiorazionePacchetto;

                    System.out.println("Il tuo preventivo per l'assicurazione auto è: " + prezzoFinale + " €");
                }

        scanner.close();
            }
        }
    }


