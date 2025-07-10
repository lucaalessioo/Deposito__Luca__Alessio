import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MissioneSpaziale {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Astronauta> astronauti = new ArrayList<>(); // Lista di astronauti
        int scelta;

        // Menu di registrazione o login
        do {
            System.out.println("\n---- MENU PRINCIPALE ----");
            System.out.println("1. Registrazione astronauta");
            System.out.println("2. Login astronauta");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = Integer.parseInt(scanner.nextLine());

            // Scelta 1 registrazione
            switch (scelta) {
                case 1:
                    registraAstronauta(scanner, astronauti); // Passo lo scanner e la lista di astronauti gi registrati
                                                             // e controllo se gia esiste quello che sto registrando
                    break;

                // Caso del login
                case 2:
                    Astronauta astronauta = loginAstronauta(scanner, astronauti);
                    if (astronauta != null) {
                        Astronauta tipoDiAstronauta;
                        if (astronauta instanceof Scienziato) {                       // se è una istanza di scienziato apro il corrispettivo menu
                            tipoDiAstronauta = menuScienziato(scanner, astronauta);       
                        } else if (astronauta instanceof Ispettore) {
                            tipoDiAstronauta = menuIspettore(scanner, astronauta);          // se è un ispettore  apre il menu ispettore
                        } else {
                            tipoDiAstronauta = astronauta;
                        }

                        // serve a sostituire nella lista astronauti l'istanza vecchia dell'astronauta con la nuova istanza aggiornata 
                        //che può essere promossa, quindi magari è diventato ScienziatoCapo o IspettoreCapo.
                        for (int i = 0; i < astronauti.size(); i++) {
                            if (astronauti.get(i).getEmail().equalsIgnoreCase(tipoDiAstronauta.getEmail())) {
                                astronauti.set(i, tipoDiAstronauta);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Login fallito.");
                    }
                    break;
            }
        } while (scelta != 0);

        scanner.close();
    }

    // Metodo per registrare un astronauta con controllo per email
    static void registraAstronauta(Scanner scanner, ArrayList<Astronauta> astronauti) {
        System.out.print("Inserisci nome: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci email: ");
        String email = scanner.nextLine();

        // Verifica email duplicata
        for (Astronauta a : astronauti) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Email già registrata."); // se l email gia esiste esco dal metodo e richiedo se si
                                                             // vuole registrare di nuovo o se si vuole fare il login
                return;
            }
        }

        // Chiedo che tipo è 
        System.out.println("Seleziona tipo astronauta:");
        System.out.println("1. Scienziato");
        System.out.println("2. Ispettore");
        System.out.print("Scelta: ");
        int tipo = Integer.parseInt(scanner.nextLine());

        Astronauta nuovo;
        if (tipo == 1)
            nuovo = new Scienziato(nome, email);       // Tipo scienziato
        else if (tipo == 2)
            nuovo = new Ispettore(nome, email);        // Tipo ispettore
        else {
            System.out.println("Tipo non valido.");
            return;
        }

        astronauti.add(nuovo)  ;                         
        System.out.println("Astronauta registrato con successo.");
    }

    // METODO DI LOGIN TRAMITE EMAIL DELL ASTRONAUTA
    static Astronauta loginAstronauta(Scanner scanner, ArrayList<Astronauta> astronauti) {
        System.out.print("Inserisci email per login: ");
        String emailLogin = scanner.nextLine();

        // Ciclo tutti gli astronauti e controllo l email inserita con l email di tutti
        // gli astronauti se trovo la corrispondenza ritorno l oggetto Astronauta
        for (Astronauta a : astronauti) {
            if (a.getEmail().equalsIgnoreCase(emailLogin)) {
                System.out.println("Login effettuato come: " + a.getNome());
                return a;
            }
        }
        System.out.println("Astronauta non trovato.");
        return null;
    }

    // METODO PER DEFINIRE CHI é L ASTRONAUTA CHE é LOGGATO
    static Astronauta scegliRuoloEApriMenu(Scanner scanner, Astronauta astronauta) {
        // se l astronauta è uno scienziato apro il menu dello scienziato
        if (astronauta instanceof Scienziato) {
            return menuScienziato(scanner, (Scienziato) astronauta);
            // stessa cosa per l ispettore
        } else if (astronauta instanceof Ispettore) {
            return menuIspettore(scanner, (Ispettore) astronauta);
        } else {
            System.out.println("Ruolo astronauta non riconosciuto.");
            return astronauta; // oppure null
        }
    }

    // MENU DELLO SCIENZIATO CHE VIENE RICHIAMATO NEL METODO SCEGLI RUOLO E APRI
    // MENU QUI SOPRA
    static Astronauta menuScienziato(Scanner scanner, Astronauta astronauta) {
        // uso una variabile locale per la promozione dinamica
        Astronauta currentAstronauta = astronauta;
        while (true) {
            System.out.println("\n--- Menu Scienziato ---");
            System.out.println("1. Visualizza dati");
            System.out.println("2. Rigenera ossigeno");
            System.out.println("3. Aggiungi esperimento");
            if (currentAstronauta instanceof ScienziatoCapo) {
                System.out.println("4. Stampa tutti gli esperimenti");
            }
            System.out.println("0. Logout");
            System.out.print("Scelta: ");

            int scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:
                    System.out.println(currentAstronauta);       // Caso 1 stampa info
                    break;
                case 2:
                    currentAstronauta.rigeneraOssiggeno();       // Caso 2 rigenera ossiggeno
                    System.out.println("Ossigeno rigenerato: " + currentAstronauta.getCreditoOssigeno());
                    break;
                case 3:
                    if (currentAstronauta instanceof Scienziato) {              // Caso 3 se è una istanza di scienziato chiedo di inserire l esperimento
                        System.out.print("Nome esperimento da aggiungere: ");
                        String esp = scanner.nextLine();
                        boolean promosso = ((Scienziato) currentAstronauta).addEsperimento(esp);   // Controllo se lo scienziato è stato promosso

                        if (promosso && !(currentAstronauta instanceof ScienziatoCapo)) {           // Se promosso 
                            System.out.println("Complimenti, sei stato promosso a Scienziato Capo!");
                            // promuovo astronauta a ScienziatoCapo mantenendo i dati
                            currentAstronauta = new ScienziatoCapo(currentAstronauta.getNome(),    // Creo l ogetto ScienziatoCapo con i dati correnti
                                    currentAstronauta.getEmail());
                        }
                    } else {
                        System.out.println("Azione non disponibile.");
                    }
                    break;
                case 4:
                    if (currentAstronauta instanceof ScienziatoCapo) {    // se è uno scienziato capo
                        ((ScienziatoCapo) currentAstronauta).stampaEsperimenti();           // Stampo gli esperimenti 
                    } else {
                        System.out.println("Scelta non valida.");
                    }
                    break;
                case 0:
                    System.out.println("Logout Scienziato.");
                    return currentAstronauta; // ritorno l'astronauta (potenzialmente promosso)
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }   

    // Menu ispettore
    static Astronauta menuIspettore(Scanner scanner, Astronauta astronauta) {
        Astronauta currentAstronauta = astronauta;
        while (true) {
            System.out.println("\n--- Menu Ispettore ---");
            System.out.println("1. Visualizza dati");
            System.out.println("2. Rigenera ossigeno");
            System.out.println("3. Inserisci valutazione");

            // se ispettore capo aggiun il 4 punto della stampa
            if (currentAstronauta instanceof IspettoreCapo) {
                System.out.println("4. Stampa tutte le valutazioni");
            }
            System.out.println("0. Logout");
            System.out.print("Scelta: ");

            int scelta = Integer.parseInt(scanner.nextLine());

            switch (scelta) {
                case 1:
                    System.out.println(currentAstronauta);       // Caso 1 stampa dettagli
                    break;
                case 2:
                    currentAstronauta.rigeneraOssiggeno();       // Caso 2 rigenera ossiggeno
                    System.out.println("Ossigeno rigenerato: " + currentAstronauta.getCreditoOssigeno());
                    break;
                case 3:                                         // Caso 3 controllo se ispettore e chiedi la valutazione dopo la 3 valutazione promuove a ispettore capo
                    if (currentAstronauta instanceof Ispettore) {
                        System.out.print("Valutazione (1-5): ");
                        int val = Integer.parseInt(scanner.nextLine());
                        boolean promosso = ((Ispettore) currentAstronauta).addValutazione(val);

                        if (promosso && !(currentAstronauta instanceof IspettoreCapo)) {            // se promosso e instanza di ispettore capo creo un nuovo ogeeto ispettore capo
                            System.out.println("Complimenti, sei stato promosso a Ispettore Capo!");
                            currentAstronauta = new IspettoreCapo(currentAstronauta.getNome(),
                                    currentAstronauta.getEmail());
                        }
                    } else {
                        System.out.println("Azione non disponibile.");
                    }
                    break;
                case 4:
                    if (currentAstronauta instanceof IspettoreCapo) {                   // se è ispettore capo stampo la valutazione
                        ((IspettoreCapo) currentAstronauta).stampaValutazioni();
                    } else {
                        System.out.println("Scelta non valida.");
                    }
                    break;
                case 0:
                    System.out.println("Logout Ispettore.");
                    return currentAstronauta;
                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}

// Classe Astronauta con getters e setters costruttore
class Astronauta {
    private String nome;
    private String email;
    private float creditoOssigeno;
    Random random = new Random();

    public Astronauta(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public float getCreditoOssigeno() {
        return creditoOssigeno;
    }

    public void setCreditoOssigeno(float creditoOssigeno) {
        this.creditoOssigeno = creditoOssigeno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Astronauta [nome=" + nome + ", email=" + email + "]";
    }

    public void rigeneraOssiggeno() {                               // Metodo per rigenerare ossiggeno
        creditoOssigeno = (float) random.nextInt(101);
    }

}

// Classe contenitore
class StazioneSpaziale {
    public static ArrayList<String> esperimenti = new ArrayList<>();
    public static ArrayList<Integer> valutazioni = new ArrayList<>();
}

// Classe scienziato
class Scienziato extends Astronauta {
    private boolean ruoloCapo = false;
    private int esperimentiInseriti = 0;

    public Scienziato(String nome, String email) {
        super(nome, email);

    }

    // Metodo per aggiungere un esperimento se la variabile esperimenti inseriti è 3 o maggiore e il ruolo non è gia capo lo imposto io a capo
    public boolean addEsperimento(String esperimento) {
        StazioneSpaziale.esperimenti.add(esperimento);
        esperimentiInseriti++;
        if (esperimentiInseriti >= 3 && !ruoloCapo) {
            ruoloCapo = true;
           
            return true;
        }
        return false;
    }
}

// Classe scienziato capo
class ScienziatoCapo extends Scienziato {
    public ScienziatoCapo(String nome, String email) {
        super(nome, email);
    }

    @Override
    public String toString() {
        return "Scienziato Capo: " + getNome() + " | Email: " + getEmail();
    }

    // Metodo specifico per il capo per stampare tutti gli esperimenti
    public void stampaEsperimenti() {
        System.out.println("--- Lista esperimenti registrati ---");
        if (StazioneSpaziale.esperimenti.isEmpty()) {
            System.out.println("Nessun esperimento registrato.");
        } else {
            for (String esp : StazioneSpaziale.esperimenti) {
                System.out.println("- " + esp);
            }
        }
    }
}

// Classe ispettore
class Ispettore extends Astronauta {

    private int valutazioniInserite = 0;
    private boolean ruoloCapo = false;

    public Ispettore(String nome, String email) {
        super(nome, email);
    }

    // Metodo addValutazione
    public boolean addValutazione(int valutazione) {
        if (valutazione < 1 || valutazione > 5) {
            System.out.println("Valutazione non valida (1-5).");
            return false;
        }
        StazioneSpaziale.valutazioni.add(valutazione);  // Aggiungo all array valutazioni la valutazione
        valutazioniInserite++;
        if (valutazioniInserite >= 3 && !ruoloCapo) {
            ruoloCapo = true;
           
            return true;
        }
        return false;
    }
}

// Classe Ispettore capo
class IspettoreCapo extends Ispettore {
    public IspettoreCapo(String nome, String email) {
        super(nome, email);
    }

    @Override
    public String toString() {
        return "Ispettore Capo: " + getNome() + " | Email: " + getEmail();
    }

    // Metodo per il capo con stampa delle valutazioni
    public void stampaValutazioni() {
        System.out.println("--- Lista valutazioni inserite ---");
        if (StazioneSpaziale.valutazioni.isEmpty()) {
            System.out.println("Nessuna valutazione registrata.");
        } else {
            for (Integer val : StazioneSpaziale.valutazioni) {
                System.out.println("- Valutazione: " + val);
            }
        }
    }
}

// Classse per il login
class User {
    private String urername;
    private String password;

    public User(String urername, String password) {
        this.urername = urername;
        this.password = password;
    }

    public String getUrername() {
        return urername;
    }

    public void setUrername(String urername) {
        this.urername = urername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [urername=" + urername + ", password=" + password + "]";
    }

}
