package dependencias;

public class Calculadora {
    iCalculo calculo;
    
    public Calculadora(iCalculo calculo){
        this.calculo = calculo;
    }
    
    public double efetuarCalculo(double a, double b){
        return calculo.efetuar(a, b);
    }
}
