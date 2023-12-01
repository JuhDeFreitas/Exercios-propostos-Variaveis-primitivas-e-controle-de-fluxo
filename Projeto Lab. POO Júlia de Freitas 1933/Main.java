import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int opcao; //aux para escolha do menu
        int hotel; //escolha do hotel para reservar
        int numQuarto; // num do quarto a ser reservado
        int confirm; //confirmação da reserva
        int numHospedes; //numero de hospedes por quarto
        int numReserva;

        //scanner para entrada de dados via teclado
        Scanner sc = new Scanner(System.in);

        //Array para os hoteis inclusos no sistema
        ArrayList <Hotel> hoteis = new ArrayList<>();

        //criação cliente para utilização do sistema
        Cliente cliente = new Cliente("Cris", "412.256.365.00");

        //criação do arquivo para armazenamento de dados
        Arquivo arq = new Arquivo();

        //criação de alguns hoteis para testar o programa
            Hotel laLuna = new Hotel("La Luna", "Avenida Paulista, 356, São Paulo");
            Hotel copacabana = new Hotel("Copacabana Palace", "Copacabana, 5100, Rio de Janeiro");
            Hotel independance = new Hotel("Independance", "Praça da liberdade, 1800, Belo Horizonte");

            //inclusão do hotesi criados no array de hoteis
            hoteis.add(laLuna);
            hoteis.add(copacabana);
            hoteis.add(independance);

        //Leitura dos arquivos e gravação das informações de cada hotel no array de hoteis
        hoteis = arq.ler(hoteis);

        //estrutura para o menu
        System.out.println("     - Bem Vindo ao Travelers! - ");
        do{
            System.out.println("\n        - Menu -   ");
            System.out.println("1 - Reservar hotel.");
            System.out.println("2 - Cancelar Reserva.");
            System.out.println("3 - Minhas reservas.");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();

            //execução dos comandos do menu
            switch (opcao){
                case 1:     //Reservar hotel
                    //escolha do hotel onde se deseja fazer a reserva do quarto
                    System.out.println("\nEscolha o hotel e localidade: ");
                    for (int i = 0; i < hoteis.size(); i++) {
                        if(hoteis.get(i) != null){
                            System.out.print(i+1);
                            hoteis.get(i).mostrarInfos();
                        }
                    }
                    hotel = sc.nextInt();
                    System.out.println("\n");

                    //visualização dos quartos e escolha de qual será reservado
                    do{
                        //mostra as opções de quartos disponiveis
                        hoteis.get(hotel-1).mostrarInfos();
                        hoteis.get(hotel-1).mostrarQuartos();
                        //solicita numero do quarto para reserva
                        System.out.println("\nDigite 0 para retornar ao menu.");
                        System.out.println("Insirao o numero do quarto para ver suas especificações ou reservar: ");
                        numQuarto = sc.nextInt();
                        numQuarto--;
                        //se for 0 retorna ao menu de quartos
                        if(numQuarto == -1){
                            break;
                        }else{  //se não,
                            //mostra as informações do quarto novamente e suas vantagens em relação ao tipo de quarto
                            //Diferenciação das classses
                            if(hoteis.get(hotel).quartos.get(numQuarto) instanceof QuartoSimples){
                                QuartoSimples quartoSimples = (QuartoSimples) hoteis.get(hotel).quartos.get(numQuarto);
                                quartoSimples.mostrarInfos();
                                quartoSimples.listarVantagens();
                            }else if(hoteis.get(hotel).quartos.get(numQuarto) instanceof QuartoDuplo){
                                QuartoDuplo quartoDuplo = (QuartoDuplo) hoteis.get(hotel).quartos.get(numQuarto);
                                quartoDuplo.mostrarInfos();
                                quartoDuplo.listarVantagens();
                            }else if(hoteis.get(hotel).quartos.get(numQuarto) instanceof QuartoSuiteMaster){
                                QuartoSuiteMaster quartoSuiteMaster = (QuartoSuiteMaster) hoteis.get(hotel).quartos.get(numQuarto);
                                quartoSuiteMaster.mostrarInfos();
                                quartoSuiteMaster.listarVantagens();
                            }
                            //Solicita confirmação ou não da reserva
                            do {
                                System.out.println("Reservar Quarto?");
                                System.out.println("1: Reservar Quarto.     0: Voltar para listas de quartos" );
                                confirm = sc.nextInt();
                                //verifica se o valor lido corresponda a uma das opções
                                if(confirm != 1 && confirm != 0)
                                    System.out.println("\nOpção inválida!\n");
                            }while(confirm != 1 && confirm != 0);
                            //realização da reserva
                            if(confirm == 1){
                                System.out.println("Quantas hospedes irão ficar no quarto? ");
                                numHospedes = sc.nextInt();
                                cliente.adicionarReseva((Quarto) hoteis.get(hotel-1).quartos.get(numQuarto), numHospedes);
                            }
                        }
                    }while(confirm != 1 && numQuarto != 0);
                    //salva as alterações realizadas no arquivo
                    arq.escrever(hoteis);
                    break;
                case 2:     //cacelar reserva
                    cliente.mostrarReservas();
                    System.out.println("Insira o numero da reserva que se deseja cancelar: ");
                    numReserva = sc.nextInt();
                    cliente.removerReserva(numReserva-1);
                    arq.escrever(hoteis); ///salva as alterações realizadas no arquivo
                    break;
                case 3:  //mostrar lista de reservas
                    cliente.mostrarReservas();
                    break;
                case 0:
                    System.out.println("\nSeção encerrada. Obrigada por utilizar os nossos serviços!");
                    break;
                default:
                    System.out.println("\nOpção invalida!");
                    break;
            }
        }while(opcao != 0);
    }
}