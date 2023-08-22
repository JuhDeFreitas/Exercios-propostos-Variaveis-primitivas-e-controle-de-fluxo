import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean start = true;
        int opcao;
        Scanner entrada = new Scanner(System.in);
        calculadora calc = new calculadora();

        do{
            System.out.println("\nCalculadora \n   MENU");
            System.out.println("1 - Somar. \n2 - Subtrair. \n3 - Multiplicar. \n4 - Dividir. \n5 - Exponenciar.");
            System.out.println("Escolha uma opção: ");
            opcao = entrada.nextInt();
            System.out.println("Primeiro numero: ");
            calc.n1 = entrada.nextInt();
            System.out.println("Segundo número: ");
            calc.n2 = entrada.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("Soma = " + calc.soma());
                    break;
                case 2:
                    System.out.println("Subtração: " + calc.subtrai());
                    break;
                case 3:
                    System.out.println("Multiplicação: " + calc.multiplica());
                    break;
                case 4:
                    System.out.println("Divisão: " + calc.divide());
                    break;
                case 5:
                    System.out.println("Exponenciação: " + calc.exponencial());
                    break;
                default:
                    start = false;
            }
        }while(start);
        System.out.println("Obrigada por utilizar a calculadora!");
    }
}