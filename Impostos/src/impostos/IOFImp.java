package impostos;

public class IOFImp implements iImposto{

    @Override
    public double calcular(double a) {
        return a*1.50;
    }
    
}
