public abstract class Quarto {
    protected int numQuarto;
    protected int numHospedes;
    protected int precoNoite;
    protected String tipoQuarto;
    protected boolean disponibilidade;

    //construtor da classe
    public Quarto(int numQuarto, int numHospedes, int precoNoite, String tipoQuarto, boolean disponibilidade) {
        this.numQuarto = numQuarto;
        this.tipoQuarto = tipoQuarto;
        this.precoNoite = precoNoite;
        this.disponibilidade = disponibilidade;
        this.numHospedes = numHospedes;
    }

    //metodos
    public void reservarQuarto(int numHospedes){
        this.disponibilidade = false;
        this.numHospedes = numHospedes;
    }
    public void cancelarReserva(){
        this.disponibilidade = true;
        this.numHospedes = 0;
    }

    public void mostrarInfos(){
        System.out.println("- Quarto " + (numQuarto+1));
        System.out.println("  Tipo: " + tipoQuarto);
        System.out.println("  Preço por noite: " + precoNoite);
        if(disponibilidade){
            System.out.println("  Status: disponível para hospedagem.");
        }
        else{
            System.out.println("  Status: Quarto já reservado.");
            System.out.println("  Hospedes no quarto: " + numHospedes);
        }
    }
    }
