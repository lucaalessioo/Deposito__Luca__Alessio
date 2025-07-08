public class ApplicationAgenziaBorsa {
    public static void main(String[] args) {

        AgenziaBorsa borsa = new AgenziaBorsa();

        Investitore privato1 = new InvestitorePrivato("Giulia");
        Investitore privato2 = new InvestitorePrivato("Lorenzo");

        Investitore banca = InvestitoreBancario.getIstanza("Banca Centrale");

        // Registriamo gli investitori
        borsa.aggiungiInvestitore(privato1);
        borsa.aggiungiInvestitore(privato2);
        borsa.aggiungiInvestitore(banca);

        // Simuliamo aggiornamenti
        borsa.aggiornaValoreAzione("AAPL", 182.3);
        borsa.aggiornaValoreAzione("ENEL", 5.75);
    }
}
