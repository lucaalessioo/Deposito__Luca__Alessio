import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioFinaleScuola {

    public static void main(String[] args) {

        // Variabili d istanza
        ArrayList<Persona> persone = new ArrayList<>();
        Scanner interi = new Scanner(System.in);
        Scanner stringhe = new Scanner(System.in);
        int scelta;

        do {
            // Menu
            System.out.println("\nMENU GESTIONE SCUOLA ");
            System.out.println("1. Aggiungi Studente");
            System.out.println("2. Aggiungi Docente");
            System.out.println("3. Visualizza Persone");
            System.out.println("0. Esci");
            System.out.print("Seleziona un'opzione: ");
            scelta = interi.nextInt();
            

            // Scelta utente
            switch (scelta) {
                case 1:                                                                 // Inserimento utente
                    System.out.println("\nInserisci Studente: ");
                    System.out.print("Nome: ");
                    String nomeStudente = stringhe.nextLine();
                    System.out.print("Età: ");
                    int etaStudente = interi.nextInt();
                    System.out.print("Classe frequentata: ");
                    String classe = stringhe.nextLine();
                    Studente nuovoStudente = new Studente(nomeStudente, etaStudente, classe); // Creo un nuovo ogetto Studente
                    persone.add(nuovoStudente);                                               // Aggiungo lo studente
                    System.out.println("Studente aggiunto con successo.");
                    break;

                case 2:                                                                 // Inserimento Docente
                    System.out.println("\nInserisci Docente: ");
                    System.out.print("Nome: ");
                    String nomeDocente = stringhe.nextLine();
                    System.out.print("Età: ");
                    int etaDocente = interi.nextInt();
                   
                    System.out.print("Materia insegnata: ");
                    String materia = stringhe.nextLine();
                    Docente nuovoDocente = new Docente(nomeDocente, etaDocente, materia); // Nuovo Docente
                    persone.add(nuovoDocente);                                            // Add del nuovo docente
                    System.out.println("Docente aggiunto con successo.");
                    break;

                case 3:                                                                 // Visualizza persone
                    System.out.println("\nElenco Persone:");
                    if (persone.isEmpty()) {                                            // Se la lista è vuota stampa di errore
                        System.out.println(" Nessuna persona registrata.");
                    } else {                                                                                // Altrimenti
                        for (Persona p : persone) {
                            System.out.println("Nome: " + p.getNome() + " - Età: " + p.getEta());           // Ciclo la lista e per ogni persona stampo i dettagli specifici
                            p.descriviRuolo();
                            if (p instanceof Registrable) {                                                 // Se è una istanza di Registrable chiamo il metodo registrazione
                                ((Registrable) p).registrazione();
                            }
                            System.out.println("---------------------------------------------");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Arrivederci!");
                    break;

                default:
                    System.out.println(" Scelta non valida.");
            }

        } while (scelta != 0);

        interi.close();
        stringhe.close();
    }
}
    

// Classe Astratta Persona
abstract class Persona {
    // Variabili d istanza
    private String nome;
    private int eta;

    // Costruttore
    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getEta() {
        return eta;
    }
    public void setEta(int eta) {
        this.eta = eta;
    }

    // toString
    @Override
    public String toString() {
        return "Persona [nome=" + nome + ", eta=" + eta + "]";
    }

    // Metdodo astratto da implementare nelle sottoclassi
    public abstract void descriviRuolo();
    
}

// Sottoclasse di Persona con implementazione dell interfaccia Registrable
class Studente extends Persona implements Registrable {

    // Campo privato dello studente in piu 
    private String classeFrequentata;
    
    // Costruttore studente con aggiunta della sua variaible
    public Studente(String nome, int eta, String classeFrequentata ) {
        super(nome, eta);
        this.classeFrequentata = classeFrequentata;
        
    }

    // Override del metodo registrazione
    @Override
    public void registrazione() {
      System.out.println("Registrazione tramite modulo online.");
    }

    // Override del metodo descriviRuolo
    @Override
    public void descriviRuolo() {
        System.out.println("Sono uno studente della classe " +classeFrequentata);
    }

}

// Sottoclasse di persona "Docente" con implementazione di Registrable
class Docente extends Persona implements Registrable {

    private String materia;    // Campo privato del docente 

    // Costruttore con aggiunta della sua variabile in piu
    public Docente(String nome, int eta, String materia) {
        super(nome, eta);
        this.materia = materia;
       
    }
    
    // toString
    @Override
    public String toString() {
        return "Docente [materia=" + materia + "]";
    }

    // Override del metodo registrazione
    @Override
    public void registrazione() {
        System.out.println("Registrazione tramite segreteria didattica..");
    }
    // Override del metodo descriviRuolo
    @Override
    public void descriviRuolo() {
      System.out.println("Sono un docente di " + materia );
    }

    // Getter e Setter
    public String getMateria() {
        return materia;
    }


    public void setMateria(String materia) {
        this.materia = materia;
    }
    
}