package dependencias;

public class Dependencias {
    public static void main(String[] args) {
        SomaImp soma=new SomaImp();
        SubtracaoImp subtracao=new SubtracaoImp();
        MultiplicacaoImp multiplicacao=new MultiplicacaoImp();
        DivisaoImp divisao = new DivisaoImp();
        
        Calculadora calc=new Calculadora(subtracao);
        
        System.out.println(calc.efetuarCalculo(1, 2));
    }
    
}
