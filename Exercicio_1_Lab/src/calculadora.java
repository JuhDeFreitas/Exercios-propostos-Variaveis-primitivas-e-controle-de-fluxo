public class calculadora {
    float n1;
    float n2;

    float multiplica(){
        return n1 * n2;
    }
    float soma(){
        return n1 + n2;
    }
    float subtrai(){
        return n1 - n2;
    }
    float divide(){
        return n1 / n2;
    }
    float exponencial(){
        float result = 1;
        for(int i = 0; i < n2; i++){
            result *= n1;
        }
        return result;
    }
}
