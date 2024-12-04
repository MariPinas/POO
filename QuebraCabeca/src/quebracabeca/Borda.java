package quebracabeca;

/**
 *
 * @author aluno
 */
public class Borda {

    private boolean a;
    private boolean b;

    public Borda(boolean a, boolean b) {
        this.a = a;
        this.b = b;
    }

    public boolean getA() {
        return a;
    }

    public boolean setA(boolean s) {
        this.a = s;
        return a;
    }

    public boolean getB() {
        return b;
    }

    public boolean setB(boolean g) {
        this.b = g;
        return b;
    }

    public boolean encaixaCom(Borda outraBorda) {
        return this.a != outraBorda.getB() && this.b != outraBorda.getA();
    }
}
