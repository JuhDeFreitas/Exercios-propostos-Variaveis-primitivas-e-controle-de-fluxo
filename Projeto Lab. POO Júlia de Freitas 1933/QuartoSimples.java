public class QuartoSimples extends Quarto implements Vantagens{
    //construtor
    public QuartoSimples(int numQuarto, int numHospedes, int precoNoite, String tipoQuarto, boolean disponibilidade) {
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
        System.out.println("  - Quarto Simples.");
        System.out.println("  - Acomoda até duas pessoas.");
        System.out.println("  - Aceita pets.\n");
    }
}
