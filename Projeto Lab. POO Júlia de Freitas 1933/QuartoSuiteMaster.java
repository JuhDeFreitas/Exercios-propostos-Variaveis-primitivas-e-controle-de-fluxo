public class QuartoSuiteMaster extends Quarto implements Vantagens{
    public QuartoSuiteMaster(int numQuarto, int numHospedes, int precoNoite, String tipoQuarto, boolean disponibilidade) {
        super(numQuarto, numHospedes, precoNoite, tipoQuarto, disponibilidade);
    }

    //metodos
    public void mostrarInfos(){
        super.mostrarInfos();
    }

    //reescrevendo a interface
    @Override
    public void listarVantagens(){
        System.out.println("  Vantagens: ");
        System.out.println("  - Quarto para casal.");
        System.out.println("  - Até 3 pessoas por quarto.");
        System.out.println("  - Banheira Exclusiva.");
        System.out.println("  - Varanda com jardin de inverno privativo.");
        System.out.println("  - Aceita pets.");
        System.out.println("  - Incluso café da manha.\n");
    }

}
