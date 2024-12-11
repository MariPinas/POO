package fatiadorfruta;
 
public class Fatiador {
    iFruta fruta;

    public Fatiador(iFruta fruta) {
        this.fruta = fruta;
    }
    
    public int fatiarFruta(int a){
        return fruta.fatiar(a);
    }
    
}
