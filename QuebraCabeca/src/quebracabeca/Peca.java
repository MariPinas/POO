package quebracabeca;

import java.util.List;

public abstract class Peca {
    
    protected Borda b1;
    protected Borda b2;
    protected Borda b3;
    protected Borda b4;

    public Peca(Borda b1, Borda b2, Borda b3, Borda b4) {
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
    }
    
    public Borda getB1() {
        return b1;
    }

    public void setB1(Borda b1) {
        this.b1 = b1;
    }

    public Borda getB2() {
        return b2;
    }

    public void setB2(Borda b2) {
        this.b2 = b2;
    }

    public Borda getB3() {
        return b3;
    }

    public void setB3(Borda b3) {
        this.b3 = b3;
    }

    public Borda getB4() {
        return b4;
    }

    public void setB4(Borda b4) {
        this.b4 = b4;
    }

    public void mostraBordas(){};
    public boolean seConecta(Peca peca){return true;};
}
