import java.util.ArrayList;

public class Hotel {
    //atributos
    private String nome;
    private String endereco;

    //Array list heterogeneo para os diferentes tipos de quartos presentes no hotel
    ArrayList <Object> quartos = new ArrayList<Object>();

    //construtor da classe
    public Hotel(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    //metodos
    public void mostrarInfos(){
        System.out.println("- Hotel " + nome + " - ");
        System.out.println("  Endereço: " + endereco);
    }
    public void mostrarQuartos (){
        System.out.println("\n- Quartos disponíveis: ");
        for (int i = 0; i < quartos.size(); i++) {
            Quarto aux = (Quarto) quartos.get(i);
            if(aux != null){
                if(aux.disponibilidade){
                    aux.mostrarInfos();
                }
            }
        }
    }
}
