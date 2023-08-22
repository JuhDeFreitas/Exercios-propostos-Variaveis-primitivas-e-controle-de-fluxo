public class combustivel {
    float ValorLitro;
    float descontoAteVinte;
    float descontoAcimaDeVinte;

    float calculaPreco(int litros){
        float preco;
        if(litros > 20){
            preco = litros * (ValorLitro * ((100-descontoAcimaDeVinte)/100));
        }
        else{
            preco = (litros * ValorLitro) * ((100-descontoAteVinte)/100);
        }
    return preco;
    }
}
