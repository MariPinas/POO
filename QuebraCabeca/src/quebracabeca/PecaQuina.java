package quebracabeca;

public class PecaQuina extends Peca {

    private int tipo;

    public PecaQuina(int tipo, Borda b1, Borda b2, Borda b3, Borda b4) {
        super(b1, b2, b3, b4);

        switch (tipo) {
            case 0:
                this.tipo = tipo;
                b1.setA(true);
                b1.setB(true);
                b4.setA(true);
                b4.setB(true);
                break;
            case 1:
                this.tipo = tipo;
                b1.setA(true);
                b1.setB(true);
                b2.setA(true);
                b2.setB(true);
                break;
            case 2:
                this.tipo = tipo;
                b2.setA(true);
                b2.setB(true);
                b3.setA(true);
                b3.setB(true);
                break;
            case 3:
                this.tipo = tipo;
                b3.setA(true);
                b3.setB(true);
                b4.setA(true);
                b4.setB(true);
                break;
        }
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean Conectar(Peca peca, int lado) {
        switch (lado) {
            case 0:
                if (tipo == 0 || tipo == 1) {
                    return false;
                } else if (this.b1.encaixaCom(b3)) {
                    return true;
                } else {
                    return false;
                }
            case 1:
                if (tipo == 0 || tipo == 1) {
                    return false;
                } else if (this.b2.encaixaCom(b4)) {
                    return true;
                } else {
                    return false;
                }

            case 2:
                if (tipo == 2 || tipo == 3) {
                    return false;
                } else if (this.b3.encaixaCom(b1)) {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (tipo == 2 || tipo == 3) {
                    return false;
                } else if (this.b3.encaixaCom(b1)) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
}
