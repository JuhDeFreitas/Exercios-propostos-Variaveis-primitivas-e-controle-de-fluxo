import java.io.*;
import java.util.ArrayList;
public class Arquivo {
    int numQuarto;
    String tipoQuarto;
    boolean disponibilidade;
    int precoNoite;
    int numHospedes;
    int hotel;
    public void escrever(ArrayList <Hotel> hoteis){
        // Importando as classes que nos permitirão escrever no Arquivo
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {
            // Recebe o nome do arquivo
            os = new FileOutputStream("DADOSQUARTOS.txt"); // Arquivo

            // Mostra em qual arquivo estaremos escrevendo
            osw = new OutputStreamWriter(os);

            // Permite que escrevamos no arquivo
            bw = new BufferedWriter(osw);
            for (int i = 0; i < hoteis.size(); i++) {
                for (int j = 0; j < hoteis.get(i).quartos.size(); j++) {
                    Quarto aux = (Quarto) hoteis.get(i).quartos.get(j);
                    bw.write("__Quarto__");
                    bw.newLine();
                    bw.write(i + "");
                    bw.newLine();
                    bw.write(j + "");
                    bw.newLine();
                    bw.write(aux.tipoQuarto + "");
                    bw.newLine();
                    bw.write(String.valueOf(aux.disponibilidade) + "");
                    bw.newLine();
                    bw.write(aux.precoNoite + "");
                    bw.newLine();
                    bw.write(aux.numHospedes + "");
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("ERRO: "+e);
        }finally{
            // Fechando a entrada de dados
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Hotel> ler(ArrayList <Hotel> hoteis){

        // Estruturas que servirão para a leitura dos dados
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        String linhaLer; // Auxiliar que servirá como ponteiro para ler o arquivo

        try{
            is = new FileInputStream("DADOSQUARTOS.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            // Posiciando o cursor no inicio do Arquivo
            linhaLer = br.readLine();

            // Verificando e rodando o código enquanto tiver informações no txt
            while(linhaLer!=null){
                // Verificando se encontramos a flag que indica o início de um livro
                if(linhaLer.contains("__Quarto__")){
                    hotel = Integer.parseInt(br.readLine());  //lendo qual hotel o quarto se encontra
                    numQuarto = Integer.parseInt(br.readLine());
                    tipoQuarto = br.readLine();
                    String s = br.readLine();
                    if(s.equalsIgnoreCase(("true")))
                        disponibilidade = true;
                    else
                        disponibilidade = false;
                    precoNoite = Integer.parseInt(br.readLine());
                    numHospedes = Integer.parseInt(br.readLine());

                    if(tipoQuarto.equalsIgnoreCase("Quarto Simples")){
                        QuartoSimples quarto = new QuartoSimples(numQuarto, numHospedes, precoNoite, tipoQuarto, disponibilidade);
                        hoteis.get(hotel).quartos.add(quarto);
                    }else if(tipoQuarto.equalsIgnoreCase("Quarto Duplo")){
                        QuartoDuplo quarto = new QuartoDuplo(numQuarto, numHospedes, precoNoite, tipoQuarto, disponibilidade);
                        hoteis.get(hotel).quartos.add(quarto);
                    }else if(tipoQuarto.equalsIgnoreCase("Quarto Suite Master")){
                        QuartoSuiteMaster quarto = new QuartoSuiteMaster(numQuarto, numHospedes, precoNoite, tipoQuarto, disponibilidade);
                        hoteis.get(hotel).quartos.add(quarto);
                    }
                }
                // Passando para a próxima linha
                linhaLer = br.readLine();
            }
        }catch(Exception e){
            System.out.println("ERRO: "+e);
        }finally{
            try{
                br.close();
            }catch(Exception e){
                System.out.println("ERRO: "+e);
            }
        }
        return hoteis;
    }
}


