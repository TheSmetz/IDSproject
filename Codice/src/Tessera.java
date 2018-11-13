import java.util.Date;

public class Tessera {
    private String nome;
    private String cognome;
    private String ID;
    private String residenzaAttuale;
    private Date dataNascita;
    private int punti;

    public Tessera(){}

    public String getNome() {
        return nome;
    }
    

    public String getCognome() {
        return cognome;
    }

    public String getID() {
        return ID;
    }

    public String getResidenzaAttuale() {
        return residenzaAttuale;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public int getPunti() {
        return punti;
    }
}
