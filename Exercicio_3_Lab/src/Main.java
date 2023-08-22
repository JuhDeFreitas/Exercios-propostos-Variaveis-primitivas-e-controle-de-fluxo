import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int litros;
        String letra;

        combustivel gasolina = new combustivel();
        combustivel alcool = new combustivel();

        gasolina.ValorLitro = 6;
        gasolina.descontoAcimaDeVinte = 6;
        gasolina.descontoAteVinte = 4;

        alcool.ValorLitro = 4.90F;
        alcool.descontoAcimaDeVinte = 5;
        alcool.descontoAteVinte = 3;

        Scanner entrada = new Scanner(System.in);
        do{
            System.out.println("Qual combustível deseja? \nG - Gasolina \nA - Alcool");
            letra = entrada.nextLine();

            System.out.println("Insira a quantidade de litros: ");
            litros = entrada.nextInt();

            switch (letra) {
                case "A", "a" -> System.out.println("Valor: " + gasolina.calculaPreco(litros));
                case "G", "g" -> System.out.println("Valor: " + alcool.calculaPreco(litros));
            }
        }while(true);

    }
}