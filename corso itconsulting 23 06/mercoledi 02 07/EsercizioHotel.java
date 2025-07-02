import java.util.ArrayList;

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


        System.out.println("Dettagli camere dell'hotel " + hotel.getNome() + ":\n");

        // ciclo tutte le camere utilizzando il metodo per farmi restituire l arraylist delle camere
        for (Camera c : hotel.getCamere()) {

            // Se è una suite, chiamo il metodo delle suite
            if (c instanceof Suite) {
                c.dettagli(); // metodo della suite con override
            } else {
                c.dettagli(true); // altrimenti il metodo normale
            }
            System.out.println("----------------------------");
        }

        // richiamo il metodo staitco per contare quante suite ci sono
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

    // ToString
    @Override
    public String toString() {
        return "Camera [numeroCamera=" + numeroCamera + ", prezzo=" + prezzo + "]";
    }
    // Metodo per stmapare tutti i dettagli
    public void dettagli() {
        System.out.println("Numero camera : "+ numeroCamera);
    }

    // Metodo per stampare i dettagli con il prezzo
    public void dettagli(boolean conPrezzo) {
        if(conPrezzo) {
             System.out.println("Numero camera : "+ numeroCamera + " prezzo camera : "+prezzo);
        } else {
            System.out.println("Numero camera: "+ numeroCamera);
        }
    }
}

// Classe suite che estende Camere
class Suite extends Camera {
    private String serviziExtra;

    // Costruttore con super per richiamare quello del padre e aggiunta di una variabile personale solo per la suite
    public Suite(int numeroCamera, float prezzo , String serviziExtra) {
        super(numeroCamera, prezzo);
        this.serviziExtra = serviziExtra;
        
    }

    // Getter e Setter
    public String getServiziExtra() {
        return serviziExtra;
    }

    public void setServiziExtra(String serviziExtra) {
        this.serviziExtra = serviziExtra;
    }

    // ToString
    @Override
    public String toString() {
        return "Suite [serviziExtra=" + serviziExtra + "]";
    }
        // Override del metodo dettagli
        @Override
        public void dettagli() {
        super.dettagli();                                           // richiamo il metodo dettagli senza parametri dalla classe padre
        System.out.println("Servizi extra: " + serviziExtra);       // aggiungo una stampa del caso il metodo è della suite
    }
}

//Classe hotel
class Hotel {
    //Variabili d istanza
    private String nome;
    private ArrayList<Camera> listaCamere;

    // Costruttore
    public Hotel(String nome) {
        this.nome = nome;
        this.listaCamere = new ArrayList<>();
    }

    // Geeters Setters
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

    // Metodo per aggiungere una camera alla lista
    public void addCamera(Camera camera) {
        listaCamere.add(camera);
    }

    public static int contaSuite(ArrayList<Camera> listaCamere) {
        int contatore = 0;
        for(Camera camera : listaCamere) {
            if(camera instanceof Suite) {
                contatore++;
            }
        }
        return contatore;
    }
    
    // ToString
    @Override
    public String toString() {
        return "Hotel [nome=" + nome + ", listaCamere=" + listaCamere + "]";
    }

    
}

