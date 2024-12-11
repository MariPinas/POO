package impostos;

public class Impostos { 
    public static void main(String[] args) {
        IOFImp iof = new IOFImp();
        IPTUImp iptu = new IPTUImp();
        
        Calculadora calculadora = new Calculadora(iptu);
        
        System.out.println(calculadora.calcularImposto(1000));
    }
    
}
