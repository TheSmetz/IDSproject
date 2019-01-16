package Console;

public class Cestino {

    private String tipo;
    private boolean pieno = false; //capienza = 100;
    private int capienza;
    private boolean integrita = true;
    private boolean bocchetta;

    public void aumentaCapienza() {
        if(this.capienza<100 && this.capienza>=0) {
            this.capienza+=1;
            System.out.println(this.capienza);
        }else {
            this.pieno=true;
        }
        //ciao
    }
    public int getCapienza() {
        return this.capienza;
    }

    public boolean isPieno() {
        return this.pieno;
    }
    public boolean isIntegrita() {
        return this.integrita;
    }
    public void setIntegrita(boolean integrita) {
        this.integrita = integrita;
    }
    public void apriBocchetta() {
        this.bocchetta = true;
    }
    public void chiudiBocchetta() {
        this.bocchetta = false;
    }

    //costruttore
    public Cestino(String tipo) {
        this.tipo = tipo;
    }

}