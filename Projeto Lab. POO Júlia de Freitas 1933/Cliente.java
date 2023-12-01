import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;

    //lista de reservas do cliente
    ArrayList <Quarto> listaReservas = new ArrayList<Quarto>();

    //construtor da classe
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void adicionarReseva(Quarto quarto, int numHospedes){
        listaReservas.add(quarto);
        quarto.reservarQuarto(numHospedes);
        System.out.println("Pedido adicionado à sua lista de reservas! ");
    }
    public void removerReserva(int numReserva){
        listaReservas.remove(numReserva);
        listaReservas.get(numReserva).cancelarReserva();
        System.out.println("Pedido retirado da sua lista de reservas.");
    }
    public void mostrarReservas(){
        System.out.println("\n\n- Lista de Reservas -");
        for (int i = 0; i < listaReservas.size(); i++) {
            if(listaReservas.get(i) != null){
                System.out.println("\n       Reserva " + (i+1));
                listaReservas.get(i).mostrarInfos();
            }
        }
    }
}
