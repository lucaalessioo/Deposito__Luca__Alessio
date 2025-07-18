import java.util.ArrayList;
import java.util.List;

//  Pattern Factory Method: Creazione di Notifiche

// Interfaccia base per tutti i tipi di notifica
interface Notifica {
    void invia();
    String getTipo();
}

// classe concreta di notifica
class NotificaEmail implements Notifica {
    private String destinatario;
    private String messaggio;

    public NotificaEmail(String destinatario, String messaggio) {
        this.destinatario = destinatario;
        this.messaggio = messaggio;
    }

    @Override
    public void invia() {
        System.out.println("Invio Email a " + destinatario + ": " + messaggio);
    }

    @Override
    public String getTipo() {
        return "Email";
    }
}

// Implementazione Notifica SMS
class NotificaSMS implements Notifica {
    private String numeroTelefono;
    private String messaggio;

    public NotificaSMS(String numeroTelefono, String messaggio) {
        this.numeroTelefono = numeroTelefono;
        this.messaggio = messaggio;
    }

    @Override
    public void invia() {
        System.out.println("Invio SMS a " + numeroTelefono + ": " + messaggio);
    }

    @Override
    public String getTipo() {
        return "SMS";
    }
}

// Implementazione Notifica Push
class PushNotification implements Notifica {
    private String idDispositivo;
    private String messaggio;

    public PushNotification(String idDispositivo, String messaggio) {
        this.idDispositivo = idDispositivo;
        this.messaggio = messaggio;
    }

    @Override
    public void invia() {
        System.out.println("Invio Push Notifica a dispositivo " + idDispositivo + ": " + messaggio);
    }

    @Override
    public String getTipo() {
        return "Push";
    }
}

// Factory Method per creare istanze di Notifica
class FabbricaNotifiche {
    public static Notifica createNotification(String type, String destinatario, String messaggio) {
        switch (type.toLowerCase()) {
            case "email":
                return new NotificaEmail(destinatario, messaggio);
            case "sms":
                return new NotificaSMS(destinatario, messaggio); // Qui 'destinatario' è il numero di telefono
            case "push":
                return new PushNotification(destinatario, messaggio); // Qui 'destinatario' è l'ID del dispositivo
            default:
                throw new IllegalArgumentException("Tipo di notifica non supportato: " + type);
        }
    }
}


//  Pattern Observer: Notifica Utenti

// Interfaccia Observer
interface OsservatoreNotifica  {
    void aggiorna(String tipoNotifica, String messaggio);
}

// Classe Concreta Observer: User
class User implements OsservatoreNotifica  {
    private String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public void aggiorna(String tipoNotifica, String messaggio) {
        System.out.println(username + " ha ricevuto una notifica " + tipoNotifica + ": " + messaggio );
    }

    public String getUsername() {
        return username;
    }
}

// Pattern Singleton: Servizio di Notifica

// Il Soggetto nel Pattern Observer (observable) è il Singleton
class ServizioNotifiche  {
    // Istanza unica della classe (Singleton)
    private static ServizioNotifiche  instance;

    // Lista degli osservatori (User)
    private List<OsservatoreNotifica> observers;

    // Singleton
    private ServizioNotifiche () {
        observers = new ArrayList<>();
        System.out.println("ServizioNotifiche : Istanza unica creata.");
    }

    // Metodo statico pubblico per ottenere l'unica istanza
    public static ServizioNotifiche  getInstance() {
        if (instance == null) {
            instance = new ServizioNotifiche ();
        }
        return instance;
    }

    // Metodi per aggiungere gli osservatori 
    public void addObserver(OsservatoreNotifica  observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("ServizioNotifiche : " + ((User)observer).getUsername() + " iscritto."); // Converto in user l observer
        }
    }

    // Rimuove osservatore
    public void removeObserver(OsservatoreNotifica  observer) {
        observers.remove(observer);
        System.out.println("ServizioNotifiche : " + ((User)observer).getUsername() + " disiscritto."); // Di nuovo conversione in user
    }

    // Metodo per inviare una notifica e avvisare gli osservatori
    public void sendNotification(String type, String destinatario, String messaggio) {
        
            // Usa il Factory Method per creare la notifica
            Notifica notification = FabbricaNotifiche.createNotification(type, destinatario, messaggio);
            
            // Invia la notifica (simulazione)
            notification.invia();
            System.out.println("Notifica di tipo " + notification.getTipo() + " inviata con successo.");

            // Notifica tutti gli osservatori registrati
            notifyObservers(notification.getTipo(), messaggio);
    }

    // Metodo per notificare gli osservatori
    private void notifyObservers(String tipoNotifica, String messaggio) {
        for (OsservatoreNotifica  observer : observers) {
            observer.aggiorna(tipoNotifica, messaggio);
        }
    }
}


public class Esercizio3 {
    public static void main(String[] args) {
        // Singleton
        ServizioNotifiche  service = ServizioNotifiche .getInstance();
    

        // Creo alcuni utenti (Observer)
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("Charlie");

        // Registro gli utenti al servizio di notifica
        service.addObserver(user1);
        service.addObserver(user2);
        service.addObserver(user3);

        System.out.println("\n-Simulazione Invio Notifica 1 (Email)");
        // Invia una notifica (il servizio userà il Factory Method e notificherà gli Observer)
        service.sendNotification("email", "ciao@libero.com", "jooooo.");

        System.out.println("\nSimulazione Invio Notifica 2 (SMS)");
        service.sendNotification("sms", "+393331234567", "aaaaaaa");

        System.out.println("\n Rimozione di un observer");
        service.removeObserver(user2);

        System.out.println("\nSimulazione Invio Notifica 3 (Push)");
        service.sendNotification("push", "dispositivo", "bellaaaaa");

        System.out.println("\nProva a ottenere un'altra istanza di ServizioNotifiche");
        ServizioNotifiche  anotherServiceReference = ServizioNotifiche .getInstance();
        System.out.println("Le due istanze sono uguali? " + (service == anotherServiceReference)); // stampa true
    }
}
