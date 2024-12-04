package quebracabeca;

import java.util.ArrayList;
import java.util.List;

public class PecaCentro extends Peca {

    private int tipo;

    public PecaCentro(int tipo, Borda b1, Borda b2, Borda b3, Borda b4) {
        super(b1, b2, b3, b4);
        this.tipo=1; //Centro = 1 , Canto = 2, Borda =3.
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    

    @Override
    public void mostraBordas() {
        System.out.println("B1: " + b1 + "B2: " + b2 + "B3: " + b3 + "B4: " + b4);
    }

   
    @Override
    public boolean seConecta(Peca peca) {
        if (this.b1.getA() == true) {
            if(peca.b1.getA()==false || peca.b2.getA()==true||peca.b3.getA()==false||peca.b4.getA()==false)
            return true;
        } else if (this.b1.getB() == false && peca.b1.getB() == true) {
            return true;
        }
        return false;
    }
}
