import java.util.Scanner;

 class Main {
    public static void main(String[] args) {
        float notaFinal;
        Nota nota = new Nota();

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a nota da primeira prova: ");
        nota.np1 = entrada.nextInt();
        System.out.println("Digite a nota da segunda prova: ");
        nota.np2 = entrada.nextInt();

        notaFinal = nota.calculaMedia();
        if(notaFinal >= 60){
            System.out.println("Passou!");
        }
        else if(notaFinal >= 30 && notaFinal < 60){
            System.out.println("Fazer NP3!");
            System.out.println("Digite a nota da  NP3: ");
            nota.np3 = entrada.nextInt();
            if(nota.np3 >= 50)
                System.out.println("Passou!");
            else
                System.out.println("Reprovado!");
        }
        else
            System.out.println("Reprovado!");
    }
}