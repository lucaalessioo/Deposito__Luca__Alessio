import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioHotel {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Hotel Pazzesco");

        // Aggiunta camere a mano
        Camera camera1 = new Camera(302, 50.0f);
        Camera camera2 = new Camera(800, 100.0f);

        // Aggiunta suite a mano
        Suite suite1 = new Suite(350, 120.0f, "Sauna, TV 90 Pollici, Netflix");
        Suite suite2 = new Suite(190, 400.0f, "Vista mare, Piscina privata");

        // Aggiungo le camere e le suite
        hotel.addCamera(camera1);
        hotel.addCamera(camera2);
        hotel.addCamera(suite1);
        hotel.addCamera(suite2);

        // Chiedo all'utente se vuole vedere il prezzo
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vuoi visualizzare anche il prezzo delle camere? (true/false): ");
        boolean mostraPrezzo = scanner.nextBoolean();
        scanner.close();

        System.out.println("\n Dettagli camere dell'hotel " + hotel.getNome() + ":\n");

        // Uso sempre dettagli(boolean), funziona per tutte le camere grazie al polimorfismo
        for (Camera c : hotel.getCamere()) {
            c.dettagli(mostraPrezzo);
            System.out.println("----------------------------");
        }

        // richiamo il metodo statico per contare quante suite ci sono
        int numeroSuite = Hotel.contaSuite(hotel.getCamere());
        System.out.println("Numero totale di suite: " + numeroSuite);
    }
}

// classe padre 
class Camera {
    private int numeroCamera;
    private float prezzo;

    public Camera(int numeroCamera, float prezzo) {
        this.numeroCamera = numeroCamera;
        this.prezzo = prezzo;
    }

    public int getNumeroCamera() {
        return numeroCamera;
    }

    public void setNumeroCamera(int numeroCamera) {
        this.numeroCamera = numeroCamera;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Camera [numeroCamera=" + numeroCamera + ", prezzo=" + prezzo + "]";
    }

    // Metodo base senza prezzo per i dettagli
    public void dettagli() {
        System.out.println("Numero camera: " + numeroCamera);
    }

    // Metodo con opzione per il prezzo per i dettagli piu prezzo
    public void dettagli(boolean conPrezzo) {
        if (conPrezzo) {
            System.out.println("Numero camera: " + numeroCamera + ", Prezzo camera: " + prezzo + "€");
        } else {
            dettagli();  // se non mette il prezzo richiama il metodo solo per i dettagli
        }
    }
}

// Classe suite che estende Camera
class Suite extends Camera {
    private String serviziExtra;

    public Suite(int numeroCamera, float prezzo, String serviziExtra) {
        super(numeroCamera, prezzo);
        this.serviziExtra = serviziExtra;
    }

    public String getServiziExtra() {
        return serviziExtra;
    }

    public void setServiziExtra(String serviziExtra) {
        this.serviziExtra = serviziExtra;
    }

    @Override
    public String toString() {
        return "Suite [serviziExtra=" + serviziExtra + "]";
    }

    // Override dettagli senza prezzo
    @Override
    public void dettagli() {
        super.dettagli();
        System.out.println("Servizi extra: " + serviziExtra);
    }

    // Override dettagli con prezzo
    @Override
    public void dettagli(boolean conPrezzo) {
        super.dettagli(conPrezzo);
        System.out.println("Servizi extra: " + serviziExtra);
    }
}

// Classe hotel
class Hotel {
    private String nome;
    private ArrayList<Camera> listaCamere;

    public Hotel(String nome) {
        this.nome = nome;
        this.listaCamere = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Camera> getCamere() {
        return listaCamere;
    }

    public void setCamere(ArrayList<Camera> listaCamere) {
        this.listaCamere = listaCamere;
    }

    public void addCamera(Camera camera) {
        listaCamere.add(camera);
    }

    // metodo statico se è una instance of di suite aumento il contatore
    public static int contaSuite(ArrayList<Camera> listaCamere) {
        int contatore = 0;
        for (Camera camera : listaCamere) {
            if (camera instanceof Suite) {
                contatore++;
            }
        }
        return contatore;
    }

    @Override
    public String toString() {
        return "Hotel [nome=" + nome + ", listaCamere=" + listaCamere + "]";
    }
}

