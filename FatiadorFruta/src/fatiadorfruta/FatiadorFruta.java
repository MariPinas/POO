package fatiadorfruta;

public class FatiadorFruta {

    public static void main(String[] args) {
        BananaImp banana = new BananaImp();
        MacaImp maca = new MacaImp();
        
        Fatiador fatiador = new Fatiador(maca);
        
        System.out.println(fatiador.fatiarFruta(10));
        
    }  
}
