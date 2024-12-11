
package impostos;


public class Calculadora {
    iImposto imposto;

    public Calculadora(iImposto imposto) {
        this.imposto = imposto;
    }
    
    public double calcularImposto(double a){
        return imposto.calcular(a);
    }
}
