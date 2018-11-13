public class Main {
    public static void main (String[] args){
        Prodotto Birra = new Prodotto("g313v12g3", "Heineken",
                "Tappo indifferenziato, bottiglia vetro", false,
                false, true, true);
        Prodotto Giornale = new Prodotto("hwgyue23", "Gazzetta",
                "Giornale carta", true, false, false,
                false);

        Birra.getMateriale();
        Birra.getCodiceABarre();
        Birra.getDescrizione();
        Giornale.getMateriale();
        Giornale.getCodiceABarre();
        Giornale.getDescrizione();

    }
}
