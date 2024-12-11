
package impostos;


public class IPTUImp implements iImposto{

    @Override
    public double calcular(double a) {
        return a*1.10;
    }
    
}
