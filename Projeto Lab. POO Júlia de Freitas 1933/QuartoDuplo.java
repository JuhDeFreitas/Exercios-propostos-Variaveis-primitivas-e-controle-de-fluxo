public class QuartoDuplo extends Quarto implements Vantagens{
    public QuartoDuplo(int numQuarto, int numHospedes, int precoNoite, String tipoQuarto, boolean disponibilidade) {
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
        System.out.println("  - Quarto para familia.");
        System.out.println("  - Até 6 pessoas por quarto.");
        System.out.println("  - Dois quartos conjugados separados por corredor interno e dois banheiros.");
        System.out.println("  - Mini cozinha.");
        System.out.println("  - Aceita pets.\n");
    }
}
